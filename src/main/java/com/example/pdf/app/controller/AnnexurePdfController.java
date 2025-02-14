package com.example.pdf.app.controller;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class AnnexurePdfController {

    @GetMapping("/annexure")
    public ResponseEntity<byte[]> generateAnnexurePdf() throws DocumentException, IOException {
        // 1. Document Setup
        Document document = new Document(PageSize.A4, 36, 36, 54, 36); // Margins: left, right, top, bottom
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        document.open();

        // 2. Fonts (Crucial for Matching)
        Font regularFont = FontFactory.getFont(FontFactory.HELVETICA, 9, BaseColor.BLACK);
        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.BLACK);
        Font sectionTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, BaseColor.BLACK);

        // 3. Header (Simple Example)
        Paragraph header = new Paragraph("Self Study Report of DHIRUBHAI AMBANI INSTITUTE OF INFORMATION AND COMMUNICATION TECHNOLOGY (DA-IICT)", regularFont);
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);

        // 4. Annexure Title
        Paragraph annexureTitle = new Paragraph("6. ANNEXURE", sectionTitleFont);
        annexureTitle.setAlignment(Element.ALIGN_CENTER);
        annexureTitle.setSpacingBefore(10); // Add some space before
        document.add(annexureTitle);

        // 5. Table Generation (Illustrative)
        PdfPTable table = createMetricsTable(regularFont, boldFont);  // Separate method for table creation
        document.add(table);

        // 6. Footer (Page Number - Example)  This is more complex with iText
        //    You'll likely need to use a PdfPageEventHelper to handle this correctly

        // 7. Closing the Document
        document.close();
        writer.close();

        // 8. HTTP Response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "annexure.pdf");
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }

    private PdfPTable createMetricsTable(Font regularFont, Font boldFont) throws DocumentException {
        PdfPTable table = new PdfPTable(2); // Two columns based on your document
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);

        // Column widths (Adjust these based on the PDF)
        float[] columnWidths = {0.6f, 0.4f}; // Example: 60% for the first column, 40% for the second
        table.setWidths(columnWidths);

        // --- Table Header ---
        addTableHeader(table, "Metric ID", boldFont);
        addTableHeader(table, "Sub Questions and Answers before and after DVV Verification", boldFont);

        // --- Row 1: 1.2.2 ---
        addTableCell(table, "1.2.2", regularFont);
        addTableCell(table, "Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented  (Data for the latest completed academic year).\n" +
                "     1.2.2.1. Number of Programmes in which CBCS / Elective course system implemented.\n" +
                "          Answer before DVV Verification :  9 \n" +
                "          Answer after DVV Verification: 8 \n" +
                "     Remark : Input edited as per supporting documents", regularFont);

        // --- Row 2: 1.3.4 ---  (Example)
        addTableCell(table, "1.3.4", regularFont);
        addTableCell(table, "Percentage  of students undertaking  field projects / research projects / internships  (Data for\n" +
                "the latest completed  academic year).\n" +
                "     1.3.4.1. Number of students undertaking field projects or research projects or internships.\n" +
                "          Answer before DVV Verification :  1386 \n" +
                "          Answer after DVV Verification: 1050 \n" +
                "     Remark : Input edited as per supporting documents", regularFont);

        // ... Add the rest of your rows here, populating with dynamic data ...

        return table;
    }

    private void addTableHeader(PdfPTable table, String headerText, Font font) {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY); // Example
        header.setBorderWidth(1); // Example
        header.setPhrase(new Phrase(headerText, font));
        table.addCell(header);
    }

    private void addTableCell(PdfPTable table, String cellText, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(cellText, font));
        cell.setBorderWidth(1);
        table.addCell(cell);
    }
}
