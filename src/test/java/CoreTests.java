import adapter.PaymentAdapter;
import adapter.PaymentInterface;
import com.temenos.fundstransfer.FUNDSTRANSFERType;
import com.temenos.sbm_insurance.*;
import core.util.AES;
import core.util.FileUtil;
import core.util.RequestUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static core.util.CoreUtil.hasOverride;
import static core.util.RequestUtil.OVERRIDE_LIST;
import static core.util.Util.AES_SECRET;


public class CoreTests {
    PaymentInterface paymentInterface;
    @Before
    public void  init(){

        RequestUtil.TWS_ENDPOINT ="http://10.245.10.30:8080/SBM-Insurance.Payment/services?wsdl";
        RequestUtil.TWS_USERNAME ="NBOL.USER";
        RequestUtil.TWS_PASSWORD ="123456";
        paymentInterface = new PaymentAdapter();
        paymentInterface.initialize();
    }

    @Test
    public void checkCustomerDetails(){
        try {
            SBGetCustomerByAccountResponse customer = paymentInterface.getCustomerDetails("1010127421004","abc");
          /*  System.out.println(customer.getSBGETCUSTOMERBYACCOUNTType().get(0).
                    getGSBGETCUSTOMERBYACCOUNTDetailType()
                    .getMSBGETCUSTOMERBYACCOUNTDetailType().get(0).getSMS1()); */
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void getSegUpdates(){
        try {
            SBGetSBSegUpdatesResponse sbGetSBSegUpdates = paymentInterface.getUpdatedPolicies("NEW","20230626");

            System.out.println(sbGetSBSegUpdates.getSBGETSBSEGUPDATESType().get(0).getGSBGETSBSEGUPDATESDetailType());
          //  System.out.println(sbGetSBSegUpdates.getSbgetsbsegupdatesType());
            System.out.println(sbGetSBSegUpdates.getStatus().getMessages());
            System.out.println(sbGetSBSegUpdates.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    @Test
    public void doPayment(){
        try {
            SBInsurancePaymentsResponse paymentsResponse = paymentInterface.postTransaction(
                    "3018650241007","MZN","100","Teste",
                    "Teste cr","MZN144310009","","Teste",
                    "MZ0010195","abc","Unit Test"
            );

            FUNDSTRANSFERType.GOVERRIDE overrides = paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE();
            List<String> overrideList = overrides.getOVERRIDE();


            List<String> collectContext = new ArrayList<>();
            collectContext.add("TOO MANY CHARACTERS");
            collectContext.add("ACCT.WITHOUT");
            collectContext.add("LIMIT.WORKING.LT.LOCKED");
            collectContext.add("ACCT.UNAUTH.OD");
            collectContext.add("EXCESS.ID");
            collectContext.add("AVAILABLE.FUNDS.EXCESS");
            collectContext.add("*U");
            collectContext.add("*C");
            collectContext.add("*D");
            collectContext.add("*M");
            collectContext.add("*AUD");
            collectContext.add("*GMO");
            collectContext.add("*NR1");
            collectContext.add("*NR2");
            collectContext.add("*AZZ");
            collectContext.add("CONTA SOB RESTRICOES DE CREDITOS");

            StringBuilder errorMessage = new StringBuilder();

            int index = 0; boolean hasOverride = false;
            int j = -1;
            for (String override : collectContext) {
                for (String o : overrideList) {
                    if(o.contains(override)){
                        errorMessage.append(o);
                        errorMessage.append(" ");
                        hasOverride = true;
                        j = index;
                        continue;
                    }

                }
                index++;


            }

            if(hasOverride){
                System.out.println("Has override "+errorMessage);
            }
            else {
                System.out.println("Has NO override");
            }

          //  System.out.println(paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE().getOVERRIDE());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void copyFile(){
        File source = new File("C:\\Users\\c000006\\Documents\\reports\\claims\\2022-06-22\\8010C3A1-76F8-4423-9BCD-C5226B0FDF02.pdf");
        File dest = new File("C:\\Users\\c000006\\Documents\\reports\\sanlam\\claim1.pdf");

        try {

            FileUtil.copyFile(source,dest);
            System.out.println("Copied");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void genPass(){
        try{
            System.out.println(AES.encrypt("12345",AES_SECRET));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void  genExcelReport(){
        String[] columns = { "First Name", "Last Name", "Email",
                "Date Of Birth" };
         List<Contact> contacts = new ArrayList<Contact>();
        try {
            contacts.add(new Contact("Sylvain", "Saurel",
                    "sylvain.saurel@gmail.com", "17/01/1980"));
            contacts.add(new Contact("Albert", "Dupond",
                    "sylvain.saurel@gmail.com", "17/08/1989"));
            contacts.add(new Contact("Pierre", "Dupont",
                    "sylvain.saurel@gmail.com", "17/07/1956"));
            contacts.add(new Contact("Mariano", "Diaz", "sylvain.saurel@gmail.com",
                    "17/05/1988"));

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Contacts");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }

            // Create Other rows and cells with contacts data
            int rowNum = 1;

            for (Contact contact : contacts) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(contact.firstName);
                row.createCell(1).setCellValue(contact.lastName);
                row.createCell(2).setCellValue(contact.email);
                row.createCell(3).setCellValue(contact.dateOfBirth);
            }

            // Resize all columns to fit the content size
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("contacts.xlsx");
            workbook.write(fileOut);
            fileOut.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public class Contact {

        public String firstName;
        public String lastName;
        public String email;
        public String dateOfBirth;

        public Contact(String firstName, String lastName, String email,
                       String dateOfBirth) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.dateOfBirth = dateOfBirth;
        }

    }


    @Test
    public void getPolicyDetail(){
        try {
            SBInsuranceGetLoanListResponse sbGetSBSegUpdatesResponse = paymentInterface.getLoanDetails("IPC11MG2333804391");

           System.out.println(sbGetSBSegUpdatesResponse.getLOANSEGLISTSERVType().get(0).
                   getGLOANSEGLISTSERVDetailType().getMLOANSEGLISTSERVDetailType().get(0).toString());
            //  System.out.println(sbGetSBSegUpdates.getSbgetsbsegupdatesType());
          //  System.out.println(sbGetSBSegUpdatesResponse.getStatus().getMessages());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void updateT24Table(){
        try {
            SBInsuranceUpdateTableResponse updateTableResponse = paymentInterface.updateMigrationStatus("NO",
                    "IPS08MG2317706252", "NEW");
            System.out.println("updated");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void checkOverrides(){
        List<String> coreErrors = Arrays.asList("TOO MANY CHARACTERS", "ACCT.WITHOUT", "ACCT.UNAUTH.OD");
        List<String> overrideFT = Collections.singletonList("ACCT.UNAUTH.OD}Unauthorised overdraft of & & on account &.{MZN}304.73}1138806111002{MZN{304.73{1138806111002{724749{224{{*U30");

        OVERRIDE_LIST = coreErrors;

        System.out.println(hasOverride(overrideFT));


    }




}
