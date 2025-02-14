// package com.example.pdf.app.controller;

// import com.itextpdf.text.*;
// import com.itextpdf.text.pdf.PdfPCell;
// import com.itextpdf.text.pdf.PdfPTable;
// import com.itextpdf.text.pdf.PdfWriter;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.io.IOException;

// @RestController
// @RequestMapping("/pdf")
// public class pdfController {

//     @GetMapping("/generate")
//     public void generatePdf(HttpServletResponse response) throws IOException, DocumentException {
//         // Set the content type and attachment header
//         response.setContentType("application/pdf");
//         response.setHeader("Content-Disposition", "attachment; filename=\"1_TRY.pdf\"");

//         // Create a new document
//         Document document = new Document();
//         PdfWriter.getInstance(document, response.getOutputStream());

//         // Open the document
//         document.open();

//         // Define fonts for headings and normal text
//         Font headingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
//         Font subHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE);
//         Font boldFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD );
//         Font normalFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
//         Font linkFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLUE);

//         // Add main heading
//         Paragraph mainHeading = new Paragraph("4. Quality Indicator Framework (QIF)", headingFont);
//         mainHeading.setAlignment(Element.ALIGN_CENTER);
//         mainHeading.setSpacingAfter(20);
//         document.add(mainHeading);

//         // Add subheading for Criterion 1
//         Paragraph criterionHeading = new Paragraph("Criterion 1 - Curricular Aspects", subHeadingFont);
//         criterionHeading.setSpacingAfter(10);
//         document.add(criterionHeading);

//         // Add subheading for 1.1 Curriculum Design and Development
//         Paragraph curriculumHeading = new Paragraph("1.1 Curriculum Design and Development", boldFont);
//         curriculumHeading.setSpacingAfter(10);
//         document.add(curriculumHeading);

//         // Add 1.1.1 content
//         Paragraph content1 = new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes (PSOs) and Course Outcomes (COs) of the Programmes offered by the Institution.", normalFont);
//         content1.setSpacingAfter(10);
//         document.add(content1);

//         // Add "Response" heading
//         Paragraph responseHeading = new Paragraph("Response:", boldFont);
//         responseHeading.setSpacingAfter(10);
//         document.add(responseHeading);

//         // Add response content
//         Paragraph responseContent = new Paragraph("The curricula at DA-IICT has been consciously developed by considering local, national, regional and global developmental needs so that students are equipped with foundational knowledge, industry relevance electives and exposure in internship and project work. The course structure of the curricula of each programme is broadly classified into three categories. The first category, referred to as Foundation, is a set of compulsory courses required to be taken by every student in the programme. The next one is formed by a set of courses, referred to as the Electives, which forms both the technical strength and humanities and social science skills of the programmes. The third one is composed of internships and projects. The curricula provide students a multi-track option where a student can achieve depth in one track and/or breadth in multiple tracks through an appropriate choice of elective courses.", normalFont);
//         responseContent.setSpacingAfter(10);
//         document.add(responseContent);

//         // Add "Local development" section
//         Paragraph localDevelopmentHeading = new Paragraph("Local development:", boldFont);
//         localDevelopmentHeading.setSpacingAfter(5);
//         document.add(localDevelopmentHeading);

//         List localDevelopmentList = new List(List.UNORDERED);
//         localDevelopmentList.add(new ListItem("A set of courses such as Language and Literature, Science, Technology and Society engage students in understanding local socio-economic-tech conditions.", normalFont));
//         localDevelopmentList.add(new ListItem("The Rural internship after the third semester of BTech program allows students to interact with the local community and understand the needs for societal development.", normalFont));
//         document.add(localDevelopmentList);

//         // Add "National development" section
//         Paragraph nationalDevelopmentHeading = new Paragraph("National development:", boldFont);
//         nationalDevelopmentHeading.setSpacingAfter(5);
//         document.add(nationalDevelopmentHeading);

//         List nationalDevelopmentList = new List(List.UNORDERED);
//         nationalDevelopmentList.add(new ListItem("The institute runs a joint MTech (CSE) program with IIT Jammu, a joint MTech (EC) program with C R Rao AIMSCS-Hyderabad and a joint MSc (Agriculture Analytics) program with AAU-Anand and IIRS-Dehradun. These put a strong focus of the institute’s objective with pan India view of its academic and research collaboration.", normalFont));
//         nationalDevelopmentList.add(new ListItem("The course on Approaches to Indian Society visualizes students about the national needs and how the young generation can engage in providing solutions to social developments of our nation.", normalFont));
//         nationalDevelopmentList.add(new ListItem("Course on Principles of Economics provides avenues to students to understand the socio-economic factors of the country.", normalFont));
//         nationalDevelopmentList.add(new ListItem("Industrial or Research internship helps students to experience solving problems and acquiring skills in scientific and empirical results.", normalFont));
//         nationalDevelopmentList.add(new ListItem("Yoga, life skills, sports make the student engage in co-curricular and extra-curricular activities apart from curricular aspects.", normalFont));
//         document.add(nationalDevelopmentList);

//         // Add "Global development" section
//         Paragraph globalDevelopmentHeading = new Paragraph("Global development:", boldFont);
//         globalDevelopmentHeading.setSpacingAfter(5);
//         document.add(globalDevelopmentHeading);

//         Paragraph globalDevelopmentContent = new Paragraph("A rich collection of electives offered in our curricula meets the students’ expectation for Global developmental needs. Different kinds of electives (ICT, Technical, Science, Open)", normalFont);
//         globalDevelopmentContent.setSpacingAfter(10);
//         document.add(globalDevelopmentContent);


        
//         // Adding a Table (Syllabus Revision Data)
//         document.add(new Paragraph("\nSyllabus Revision Statistics (Last 5 Years):", boldFont));
//         PdfPTable table = new PdfPTable(6); // 6 columns
//         table.setWidthPercentage(100);
//         table.setSpacingBefore(10f);

//         // Table Headers
//         String[] headers = { "Year", "2021-22", "2020-21", "2019-20", "2018-19", "2017-18" };
//         for (String header : headers) {
//             PdfPCell cell = new PdfPCell(new Phrase(header, boldFont));
//             cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//             table.addCell(cell);
//         }

//         // Table Data
//         String[] data = { "Courses Revised", "186", "177", "170", "152", "157" };
//         for (String cellData : data) {
//             PdfPCell cell = new PdfPCell(new Phrase(cellData, normalFont));
//             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//             table.addCell(cell);
//         }
//         document.add(table);

//         // Adding a hyperlink
//         document.add(new Paragraph("\nFor more details, visit: ", boldFont));
//         Anchor link = new Anchor("NAAC Official Report", linkFont);
//         link.setReference("https://assessmentonline.naac.gov.in");
//         document.add(link);

        

//         // Close the document
//         document.close();
//     }
// }
package com.example.pdf.app.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class pdfController {

    @GetMapping("/generate")
    public void generatePdf(HttpServletResponse response) throws IOException, DocumentException {
        // Set the content type and attachment header
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"4_try.pdf\"");

        // Create a new document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        // Open the document
        document.open();

        // Define fonts for headings and normal text
        Font headingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
        Font subHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE);
        Font boldFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD);
        Font normalFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
        Font linkFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLUE);

        // Add main heading
        Paragraph mainHeading = new Paragraph("4. Quality Indicator Framework (QIF)", headingFont);
        mainHeading.setAlignment(Element.ALIGN_CENTER);
        mainHeading.setSpacingAfter(20);
        document.add(mainHeading);

        // Add subheading for Criterion 1
        Paragraph criterionHeading = new Paragraph("Criterion 1 - Curricular Aspects", subHeadingFont);
        criterionHeading.setSpacingAfter(10);
        document.add(criterionHeading);

        // Add subheading for 1.1 Curriculum Design and Development
        Paragraph curriculumHeading = new Paragraph("1.1 Curriculum Design and Development", boldFont);
        curriculumHeading.setSpacingAfter(10);
        document.add(curriculumHeading);

        // Add 1.1.1 content
        Paragraph content1 = new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes (PSOs) and Course Outcomes (COs) of the Programmes offered by the Institution.", normalFont);
        content1.setSpacingAfter(10);
        document.add(content1);

        // Add "Response" heading
        Paragraph responseHeading = new Paragraph("Response:", boldFont);
        responseHeading.setSpacingAfter(10);
        document.add(responseHeading);

        // Add response content
        Paragraph responseContent = new Paragraph("The curricula at DA-IICT has been consciously developed by considering local, national, regional and global developmental needs so that students are equipped with foundational knowledge, industry relevance electives and exposure in internship and project work. The course structure of the curricula of each programme is broadly classified into three categories. The first category, referred to as Foundation, is a set of compulsory courses required to be taken by every student in the programme. The next one is formed by a set of courses, referred to as the Electives, which forms both the technical strength and humanities and social science skills of the programmes. The third one is composed of internships and projects. The curricula provide students a multi-track option where a student can achieve depth in one track and/or breadth in multiple tracks through an appropriate choice of elective courses.", normalFont);
        responseContent.setSpacingAfter(10);
        document.add(responseContent);

        // Add "Local development" section
        Paragraph localDevelopmentHeading = new Paragraph("Local development:", boldFont);
        localDevelopmentHeading.setSpacingAfter(5);
        document.add(localDevelopmentHeading);

        List localDevelopmentList = new List(List.UNORDERED);
        localDevelopmentList.add(new ListItem("A set of courses such as Language and Literature, Science, Technology and Society engage students in understanding local socio-economic-tech conditions.", normalFont));
        localDevelopmentList.add(new ListItem("The Rural internship after the third semester of BTech program allows students to interact with the local community and understand the needs for societal development.", normalFont));
        document.add(localDevelopmentList);

        // Add "National development" section
        Paragraph nationalDevelopmentHeading = new Paragraph("National development:", boldFont);
        nationalDevelopmentHeading.setSpacingAfter(5);
        document.add(nationalDevelopmentHeading);

        List nationalDevelopmentList = new List(List.UNORDERED);
        nationalDevelopmentList.add(new ListItem("The institute runs a joint MTech (CSE) program with IIT Jammu, a joint MTech (EC) program with C R Rao AIMSCS-Hyderabad and a joint MSc (Agriculture Analytics) program with AAU-Anand and IIRS-Dehradun. These put a strong focus of the institute’s objective with pan India view of its academic and research collaboration.", normalFont));
        nationalDevelopmentList.add(new ListItem("The course on Approaches to Indian Society visualizes students about the national needs and how the young generation can engage in providing solutions to social developments of our nation.", normalFont));
        nationalDevelopmentList.add(new ListItem("Course on Principles of Economics provides avenues to students to understand the socio-economic factors of the country.", normalFont));
        nationalDevelopmentList.add(new ListItem("Industrial or Research internship helps students to experience solving problems and acquiring skills in scientific and empirical results.", normalFont));
        nationalDevelopmentList.add(new ListItem("Yoga, life skills, sports make the student engage in co-curricular and extra-curricular activities apart from curricular aspects.", normalFont));
        document.add(nationalDevelopmentList);

        // Add "Global development" section
        Paragraph globalDevelopmentHeading = new Paragraph("Global development:", boldFont);
        globalDevelopmentHeading.setSpacingAfter(5);
        document.add(globalDevelopmentHeading);

        Paragraph globalDevelopmentContent = new Paragraph("A rich collection of electives offered in our curricula meets the students’ expectation for Global developmental needs. Different kinds of electives (ICT, Technical, Science, Open)", normalFont);
        globalDevelopmentContent.setSpacingAfter(10);
        document.add(globalDevelopmentContent);

        // Add Self Study Report section
        Paragraph selfStudyReportHeading = new Paragraph("Self Study Report of DHIRUBHAI AMBANI INSTITUTE OF INFORMATION AND COMMUNICATION TECHNOLOGY (DA-IICT)", boldFont);
        selfStudyReportHeading.setSpacingAfter(10);
        document.add(selfStudyReportHeading);

        // Add table for File Description and Document links
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);

        // Add table headers
        table.addCell(createCell("File Description", boldFont));
        table.addCell(createCell("Document", boldFont));

        // Add table rows
        table.addCell(createCell("Upload Additional information", normalFont));
        table.addCell(createCell("View Document", linkFont));

        table.addCell(createCell("Link for Additional information", normalFont));
        table.addCell(createCell("View Document", linkFont));

        document.add(table);

        // Add 1.1.2 section
        Paragraph section112Heading = new Paragraph("1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.", boldFont);
        section112Heading.setSpacingAfter(10);
        document.add(section112Heading);

        Paragraph section112Response = new Paragraph("Response: 100", normalFont);
        section112Response.setSpacingAfter(10);
        document.add(section112Response);

        // Add 1.1.2.1 section
        Paragraph section1121Heading = new Paragraph("1.1.2.1 How many Programmes were revised out of total number of Programmes offered during the last five years", boldFont);
        section1121Heading.setSpacingAfter(5);
        document.add(section1121Heading);

        Paragraph section1121Response = new Paragraph("Response: 9", normalFont);
        section1121Response.setSpacingAfter(10);
        document.add(section1121Response);

        // Add 1.1.2.2 section
        Paragraph section1122Heading = new Paragraph("1.1.2.2 Number of all Programmes offered by the institution during the last five years.", boldFont);
        section1122Heading.setSpacingAfter(5);
        document.add(section1122Heading);

        Paragraph section1122Response = new Paragraph("Response: 9", normalFont);
        section1122Response.setSpacingAfter(10);
        document.add(section1122Response);

        // Add table for File Description and Document links for 1.1.2
        PdfPTable table112 = new PdfPTable(2);
        table112.setWidthPercentage(100);
        table112.setSpacingBefore(10);
        table112.setSpacingAfter(10);

        // Add table headers
        table112.addCell(createCell("File Description", boldFont));
        table112.addCell(createCell("Document", boldFont));

        // Add table rows
        table112.addCell(createCell("Minutes of relevant Academic Council/BOS meeting", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Institutional data in prescribed format", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Details of Programme syllabus revision in last 5 years", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Any additional information", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        table112.addCell(createCell("Link for additional information", normalFont));
        table112.addCell(createCell("View Document", linkFont));

        document.add(table112);

        // Add 1.1.3 section
        Paragraph section113Heading = new Paragraph("1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/skill development offered by the institution during the last five years", boldFont);
        section113Heading.setSpacingAfter(10);
        document.add(section113Heading);

        Paragraph section113Response = new Paragraph("Response: 100", normalFont);
        section113Response.setSpacingAfter(10);
        document.add(section113Response);

        // Add 1.1.3.1 section
        Paragraph section1131Heading = new Paragraph("1.1.3.1 Number of courses having focus on employability/ entrepreneurship/skill development year-wise during the last five years", boldFont);
        section1131Heading.setSpacingAfter(5);
        document.add(section1131Heading);

        // Add table for year-wise data
        PdfPTable table1131 = new PdfPTable(5);
        table1131.setWidthPercentage(100);
        table1131.setSpacingBefore(10);
        table1131.setSpacingAfter(10);

        // Add table headers
        table1131.addCell(createCell("2021-22", boldFont));
        table1131.addCell(createCell("2020-21", boldFont));
        table1131.addCell(createCell("2019-20", boldFont));
        table1131.addCell(createCell("2018-19", boldFont));
        table1131.addCell(createCell("2017-18", boldFont));

        // Add table rows
        table1131.addCell(createCell("186", normalFont));
        table1131.addCell(createCell("177", normalFont));
        table1131.addCell(createCell("170", normalFont));
        table1131.addCell(createCell("152", normalFont));
        table1131.addCell(createCell("157", normalFont));

        document.add(table1131);

        // Add table for File Description and Document links for 1.1.3
        PdfPTable table113 = new PdfPTable(2);
        table113.setWidthPercentage(100);
        table113.setSpacingBefore(10);
        table113.setSpacingAfter(10);

        // Add table headers
        table113.addCell(createCell("File Description", boldFont));
        table113.addCell(createCell("Document", boldFont));

        // Add table rows
        table113.addCell(createCell("Programme/ Curriculum/Syllabus of the courses", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("MoU's with relevant organizations for these courses, if any", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("Minutes of the Boards of Studies/Academic Council meetings with approvals for these courses", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("Institutional data in prescribed format", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        table113.addCell(createCell("Any additional information", normalFont));
        table113.addCell(createCell("View Document", linkFont));

        document.add(table113);

        // Add 1.2 Academic Flexibility section
        Paragraph section12Heading = new Paragraph("1.2 Academic Flexibility", boldFont);
        section12Heading.setSpacingAfter(10);
        document.add(section12Heading);

        // Add 1.2.1 section
        Paragraph section121Heading = new Paragraph("1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.", boldFont);
        section121Heading.setSpacingAfter(10);
        document.add(section121Heading);

        Paragraph section121Response = new Paragraph("Response: 68.73", normalFont);
        section121Response.setSpacingAfter(10);
        document.add(section121Response);

        // Add 1.2.1.1 section
        Paragraph section1211Heading = new Paragraph("1.2.1.1 How many new courses were introduced within the last five years.", boldFont);
        section1211Heading.setSpacingAfter(5);
        document.add(section1211Heading);

        Paragraph section1211Response = new Paragraph("Response: 222", normalFont);
        section1211Response.setSpacingAfter(10);
        document.add(section1211Response);

        // Add 1.2.1.2 section
        Paragraph section1212Heading = new Paragraph("1.2.1.2 Number of courses offered by the institution across all programmes during the last five years.", boldFont);
        section1212Heading.setSpacingAfter(5);
        document.add(section1212Heading);

        Paragraph section1212Response = new Paragraph("Response: 323", normalFont);
        section1212Response.setSpacingAfter(10);
        document.add(section1212Response);

        // Add table for File Description and Document links for 1.2.1
        PdfPTable table121 = new PdfPTable(2);
        table121.setWidthPercentage(100);
        table121.setSpacingBefore(10);
        table121.setSpacingAfter(10);

        // Add table headers
        table121.addCell(createCell("File Description", boldFont));
        table121.addCell(createCell("Document", boldFont));

        // Add table rows
        table121.addCell(createCell("Minutes of relevant Academic Council/BOS meeting", normalFont));
        table121.addCell(createCell("View Document", linkFont));

        table121.addCell(createCell("Institutional data in prescribed format", normalFont));
        table121.addCell(createCell("View Document", linkFont));

        table121.addCell(createCell("Any additional information", normalFont));
        table121.addCell(createCell("View Document", linkFont));

        document.add(table121);

        // Add 1.2.2 section
        Paragraph section122Heading = new Paragraph("1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).", boldFont);
        section122Heading.setSpacingAfter(10);
        document.add(section122Heading);

        Paragraph section122Response = new Paragraph("Response: 88.89", normalFont);
        section122Response.setSpacingAfter(10);
        document.add(section122Response);

        // Add 1.2.2.1 section
        Paragraph section1221Heading = new Paragraph("1.2.2.1 Number of Programmes in which CBCS / Elective course system implemented.", boldFont);
        section1221Heading.setSpacingAfter(5);
        document.add(section1221Heading);

        Paragraph section1221Response = new Paragraph("Response: 8", normalFont);
        section1221Response.setSpacingAfter(10);
        document.add(section1221Response);

        // Close the document
        document.close();
    }

    // Helper method to create a cell with specified font
    private PdfPCell createCell(String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(5);
        return cell;
    }
}