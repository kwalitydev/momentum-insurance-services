package dao.interfaces;


import dao.entities.FileTransferLog;

public interface FileTransferLogInterface {
    <S extends FileTransferLog> S save(S a);

}
