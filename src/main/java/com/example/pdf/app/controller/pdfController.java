package com.example.pdf.app.controller;

import com.itextpdf.text.*;
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
        response.setHeader("Content-Disposition", "attachment; filename=\"1_TRY.pdf\"");

        // Create a new document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        // Open the document
        document.open();

        // Define fonts for headings and normal text
        Font headingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 18, Font.BOLD | Font.UNDERLINE);
        Font subHeadingFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, Font.BOLD | Font.UNDERLINE);
        Font boldFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, Font.BOLD );
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

        

        // Close the document
        document.close();
    }
}
