package com.richard.nimble.feature_survey.data.repository

import com.google.gson.Gson
import com.richard.nimble.feature_survey.data.remote.SurveyApi
import com.richard.nimble.feature_survey.data.remote.dto.SurveyDetailsResponse
import com.richard.nimble.feature_survey.data.remote.dto.SurveyListResponse
import com.richard.nimble.feature_survey.data.remote.dto.toSurvey
import com.richard.nimble.feature_survey.domain.Survey
import com.richard.nimble.feature_survey.domain.SurveysSignature
import javax.inject.Inject

class FakeSurveyImpl @Inject constructor(
    private val api : SurveyApi
) : SurveysSignature {

    val fakedata = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"d5de6a8f8f5f1cfe51bc\",\n" +
            "      \"type\": \"survey\",\n" +
            "      \"attributes\": {\n" +
            "        \"title\": \"Scarlett Bangkok\",\n" +
            "        \"description\": \"We'd love ot hear from you!\",\n" +
            "        \"thank_email_above_threshold\": \"<span style=\\\"font-family:arial,helvetica,sans-serif\\\"><span style=\\\"font-size:14px\\\">Dear {name},<br /><br />Thank you for visiting Scarlett Wine Bar &amp; Restaurant at Pullman Bangkok Hotel G &nbsp;and for taking the time to complete our guest feedback survey!<br /><br />Your feedback is very important to us and each survey is read individually by the management and owners shortly after it is sent. We discuss comments and suggestions at our daily meetings and use them to constantly improve our services.<br /><br />We would very much appreciate it if you could take a few more moments and review us on TripAdvisor regarding your recent visit. By <a href=\\\"https://www.tripadvisor.com/Restaurant_Review-g293916-d2629404-Reviews-Scarlett_Wine_Bar_Restaurant-Bangkok.html\\\">clicking here</a> you will be directed to our page.&nbsp;<br /><br />Thank you once again and we look forward to seeing you soon!<br /><br />The Team at Scarlett Wine Bar &amp; Restaurant&nbsp;</span></span><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">Pullman Bangkok Hotel G</span>\",\n" +
            "        \"thank_email_below_threshold\": \"<span style=\\\"font-size:14px\\\"><span style=\\\"font-family:arial,helvetica,sans-serif\\\">Dear {name},<br /><br />Thank you for visiting&nbsp;</span></span><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">Uno Mas at Centara Central World&nbsp;</span><span style=\\\"font-size:14px\\\"><span style=\\\"font-family:arial,helvetica,sans-serif\\\">&nbsp;and for taking the time to complete our customer&nbsp;feedback survey.</span></span><br /><br /><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">The Team at&nbsp;</span><span style=\\\"font-family:arial,helvetica,sans-serif\\\"><span style=\\\"font-size:14px\\\">Scarlett Wine Bar &amp; Restaurant&nbsp;</span></span><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">Pullman Bangkok Hotel G</span>\",\n" +
            "        \"is_active\": true,\n" +
            "        \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_\",\n" +
            "        \"created_at\": \"2017-01-23T07:48:12.991Z\",\n" +
            "        \"active_at\": \"2015-10-08T07:04:00.000Z\",\n" +
            "        \"inactive_at\": null,\n" +
            "        \"survey_type\": \"Restaurant\"\n" +
            "      },\n" +
            "      \"relationships\": {\n" +
            "        \"questions\": {\n" +
            "          \"data\": [\n" +
            "            {\n" +
            "              \"id\": \"d3afbcf2b1d60af845dc\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"940d229e4cd87cd1e202\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"ea0555f328b3b0124127\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"16e68f5610ef0e0fa4db\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"bab38ad82eaf22afcdfe\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"85275a0bf28a6f3b1e63\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"642770376f7cd0c87d3c\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"b093a6ad9a6a466fa787\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"e593b2fa2f81891a2b1e\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"c3a9b8ce5c2356010703\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"fbf5d260de1ee6195473\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"4372463ce56db58c0983\",\n" +
            "              \"type\": \"question\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"ed1d4f0ff19a56073a14\",\n" +
            "      \"type\": \"survey\",\n" +
            "      \"attributes\": {\n" +
            "        \"title\": \"ibis Bangkok Riverside\",\n" +
            "        \"description\": \"We'd love to hear from you!\",\n" +
            "        \"thank_email_above_threshold\": \"Dear {name},<br /><br />Thank you for visiting Beach Republic and for taking the time to complete our brief survey. We are thrilled that you enjoyed your time with us! If you have a moment, we would be greatly appreciate it if you could leave a short review on <a href=\\\"http://www.tripadvisor.com/Hotel_Review-g1188000-d624070-Reviews-Beach_Republic_The_Residences-Lamai_Beach_Maret_Ko_Samui_Surat_Thani_Province.html\\\">TripAdvisor</a>. It helps to spread the word and let others know about the Beach Republic Revolution!<br /><br />Thank you again and we look forward to welcoming you back soon.<br /><br />Sincerely,<br /><br />Beach Republic Team\",\n" +
            "        \"thank_email_below_threshold\": \"Dear {name},<br /><br />Thank you for visiting Beach Republic and for taking the time to complete our brief survey. We are constantly striving to improve and your feedback allows us to help improve the experience for you on your next visit. Each survey is read individually by senior staff and discussed with the team in daily meetings.&nbsp;<br /><br />Thank you again and we look forward to welcoming you back soon.<br /><br />Sincerely,<br /><br />Beach Republic Team\",\n" +
            "        \"is_active\": true,\n" +
            "        \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/287db81c5e4242412cc0_\",\n" +
            "        \"created_at\": \"2017-01-23T03:32:24.585Z\",\n" +
            "        \"active_at\": \"2016-01-22T04:12:00.000Z\",\n" +
            "        \"inactive_at\": null,\n" +
            "        \"survey_type\": \"Hotel\"\n" +
            "      },\n" +
            "      \"relationships\": {\n" +
            "        \"questions\": {\n" +
            "          \"data\": [\n" +
            "            {\n" +
            "              \"id\": \"fa385b75617d98e069a3\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"1b03688d4af8a5c6b1e0\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"6e2b6ee71d3011cc0ac1\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"29272d3bac5725b4c2cf\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"7f164dd6150e6113f8ad\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"1d13ef20807de4f752c7\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"d06378d7ab2925282ecd\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"4c1e9486cf95ba54dac8\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"b8f06895134eb1da2d13\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"e9e2518333211ee2e5c8\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"81c9ae82f32f93c2967d\",\n" +
            "              \"type\": \"question\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"id\": \"2ecd2926eb02e7a58024\",\n" +
            "              \"type\": \"question\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"meta\": {\n" +
            "    \"page\": 1,\n" +
            "    \"pages\": 10,\n" +
            "    \"page_size\": 2,\n" +
            "    \"records\": 20\n" +
            "  }\n" +
            "}"
    override suspend fun getSurveys(): List<Survey> {
        return Gson().fromJson(fakedata, SurveyListResponse::class.java)
            .data.map{
                it.toSurvey()
            }

    }

    override suspend fun getSurveyDetails(id: String): Survey {
       return Gson().fromJson(Faker.surveyDetails,
           SurveyDetailsResponse::class.java).toSurvey()
    }
}