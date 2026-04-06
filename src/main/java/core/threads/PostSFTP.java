package core.threads;

import core.beans.SFTPContext;
import core.constants.Statuses;
import dao.entities.FileTransferLog;
import dao.interfaces.FileTransferLogInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.File;
import java.util.function.Function;

import static core.util.CoreUtil.formatDate;
import static core.util.CoreUtil.today;
import static core.util.FileUtil.BASE_DIRECTORY;
import static core.util.FileUtil.copyFile;
import static core.util.Util.TIMESTAMP_PATTERN;
import static core.util.Util.setStatus;


@Dependent
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class PostSFTP implements Function<SFTPContext,String> {

    @Inject
    private FileTransferLogInterface fileTransferLogInterface;
    private static final Logger LOGGER = LogManager.getLogger(PostSFTP.class);


    @Override
    public String apply(SFTPContext sftpContext) {
        FileTransferLog fileTransferLog = new FileTransferLog();
        try {
            setupFileTransferLog(fileTransferLog, sftpContext);

            String source = BASE_DIRECTORY + sftpContext.getDocumentFile().getUrl();
            String destination = createDestinationPath(sftpContext);
            LOGGER.info("Source -> {}, Destination -> {}. traceId -> {}", source, destination, sftpContext.getTraceId());

            File sourceFile = new File(source);
            File destinationFile = new File(destination);
            transferFile(fileTransferLog, sourceFile, destinationFile, sftpContext);

        } catch (Exception e) {
            LOGGER.error("Error while creating file", e);
            fileTransferLog.setStatus(setStatus(Statuses.ERROR.toString()));
        } finally {
            saveFileTransferLog(fileTransferLog);
        }

        return null;
    }

    private void setupFileTransferLog(FileTransferLog fileTransferLog, SFTPContext sftpContext) {

        fileTransferLog.setFileGenerated(true);
        fileTransferLog.setAttemptDate(today());
    }

    private String createDestinationPath(SFTPContext sftpContext) {
        return  sftpContext.getDocumentFile().getDocumentType().getDescription() + "_" +
                formatDate(today(), TIMESTAMP_PATTERN) + "_" + sftpContext.getDocumentFile().getTitle();
    }

    private void transferFile(FileTransferLog fileTransferLog, File sourceFile, File destinationFile, SFTPContext sftpContext) {
        try {
            fileTransferLog.setStatus(setStatus(Statuses.APPROVED.toString()));
            fileTransferLog.setDir(destinationFile.getPath());

            LOGGER.info("Copying file {}", sftpContext.getDocumentFile().getDescription());
            copyFile(sourceFile, destinationFile);
            LOGGER.info("File {} copied!", destinationFile.getPath());
        } catch (Exception e) {
            fileTransferLog.setStatus(setStatus(Statuses.ERROR.toString()));
            fileTransferLog.setErrorMessage(e.getMessage());
            LOGGER.error("Error while copying file", e);
        }
    }

    private void saveFileTransferLog(FileTransferLog fileTransferLog) {
        FileTransferLog transferLog = fileTransferLogInterface.save(fileTransferLog);
        LOGGER.info("FileTransferLog saved! id -> {}", transferLog.getFileId());
    }



}
