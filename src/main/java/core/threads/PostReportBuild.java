package core.threads;

import api.ReportAPI;
import core.beans.ReportRequest;
import core.util.QueryUtil;
import dao.entities.DocumentFile;
import dao.entities.InsurancePolicy;
import dao.interfaces.InsurancePolicyInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.function.Function;



@ApplicationScoped
public class PostReportBuild implements Function<ReportRequest, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostReportBuild.class);

    @Inject
    private ReportAPI reportAPI;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;

    @Override
    public String apply(ReportRequest reportRequest) {
        try {
            if (!reportRequest.isRegenerate()) {
                generateReport(reportRequest);
            } else {
                regenerateReport(reportRequest);
            }
        } catch (Exception e) {
            LOGGER.error("Error building report. traceId -> {}", reportRequest.getTraceId(), e);
        }
        return null;
    }

    private void generateReport(ReportRequest reportRequest) throws Exception {
        LOGGER.info("Generating report. details -> {}. traceId -> {}", reportRequest, reportRequest.getTraceId());
        DocumentFile df = reportAPI.genPolicyProof(reportRequest);
        if (df != null) {
            queryUtil.saveDocumentFile(df);
        } else {
            LOGGER.info("Document file is null. traceId -> {}", reportRequest.getTraceId());
        }
    }

    private void regenerateReport(ReportRequest reportRequest) throws Exception {
        LOGGER.info("Re-generating report. traceId -> {}", reportRequest.getTraceId());
        Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(reportRequest.getPolicyId());
        if (insurancePolicy.isPresent()) {
            DocumentFile documentFile = reportAPI.genPolicyProof(reportRequest);
            int dbDocumentFile = queryUtil.updateDocumentFile(documentFile.getUrl(), reportRequest.getPolicyId(), insurancePolicy.get().getRecordType());
            if (dbDocumentFile > 0) {
                LOGGER.info("Document file updated. traceId -> {}", reportRequest.getTraceId());
            }
        } else {
            LOGGER.info("Policy not found. PolicyId -> {}. traceId -> {}", reportRequest.getPolicyId(), reportRequest.getTraceId());
        }
    }






}
