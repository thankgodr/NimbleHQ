package com.richard.nimble.feature_survey.data.repository

object Faker {
    const val surveyDetails = "{\n" +
            "  \"data\": {\n" +
            "    \"id\": \"d5de6a8f8f5f1cfe51bc\",\n" +
            "    \"type\": \"survey\",\n" +
            "    \"attributes\": {\n" +
            "      \"title\": \"Scarlett Bangkok\",\n" +
            "      \"description\": \"We'd love ot hear from you!\",\n" +
            "      \"thank_email_above_threshold\": \"<span style=\\\"font-family:arial,helvetica,sans-serif\\\"><span style=\\\"font-size:14px\\\">Dear {name},<br /><br />Thank you for visiting Scarlett Wine Bar &amp; Restaurant at Pullman Bangkok Hotel G &nbsp;and for taking the time to complete our guest feedback survey!<br /><br />Your feedback is very important to us and each survey is read individually by the management and owners shortly after it is sent. We discuss comments and suggestions at our daily meetings and use them to constantly improve our services.<br /><br />We would very much appreciate it if you could take a few more moments and review us on TripAdvisor regarding your recent visit. By <a href=\\\"https://www.tripadvisor.com/Restaurant_Review-g293916-d2629404-Reviews-Scarlett_Wine_Bar_Restaurant-Bangkok.html\\\">clicking here</a> you will be directed to our page.&nbsp;<br /><br />Thank you once again and we look forward to seeing you soon!<br /><br />The Team at Scarlett Wine Bar &amp; Restaurant&nbsp;</span></span><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">Pullman Bangkok Hotel G</span>\",\n" +
            "      \"thank_email_below_threshold\": \"<span style=\\\"font-size:14px\\\"><span style=\\\"font-family:arial,helvetica,sans-serif\\\">Dear {name},<br /><br />Thank you for visiting&nbsp;</span></span><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">Uno Mas at Centara Central World&nbsp;</span><span style=\\\"font-size:14px\\\"><span style=\\\"font-family:arial,helvetica,sans-serif\\\">&nbsp;and for taking the time to complete our customer&nbsp;feedback survey.</span></span><br /><br /><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">The Team at&nbsp;</span><span style=\\\"font-family:arial,helvetica,sans-serif\\\"><span style=\\\"font-size:14px\\\">Scarlett Wine Bar &amp; Restaurant&nbsp;</span></span><span style=\\\"font-family:arial,helvetica,sans-serif; font-size:14px\\\">Pullman Bangkok Hotel G</span>\",\n" +
            "      \"is_active\": true,\n" +
            "      \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_\",\n" +
            "      \"created_at\": \"2017-01-23T07:48:12.991Z\",\n" +
            "      \"active_at\": \"2015-10-08T07:04:00.000Z\",\n" +
            "      \"inactive_at\": null,\n" +
            "      \"survey_type\": \"Restaurant\"\n" +
            "    },\n" +
            "    \"relationships\": {\n" +
            "      \"questions\": {\n" +
            "        \"data\": [\n" +
            "          {\n" +
            "            \"id\": \"d3afbcf2b1d60af845dc\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"940d229e4cd87cd1e202\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"ea0555f328b3b0124127\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"16e68f5610ef0e0fa4db\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"bab38ad82eaf22afcdfe\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"85275a0bf28a6f3b1e63\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"642770376f7cd0c87d3c\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"b093a6ad9a6a466fa787\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"e593b2fa2f81891a2b1e\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"c3a9b8ce5c2356010703\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"fbf5d260de1ee6195473\",\n" +
            "            \"type\": \"question\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"4372463ce56db58c0983\",\n" +
            "            \"type\": \"question\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"included\": [\n" +
            "    {\n" +
            "      \"id\": \"d3afbcf2b1d60af845dc\",\n" +
            "      \"type\": \"question\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"\\nThank you for visiting Scarlett!\\n Please take a moment to share your feedback.\",\n" +
            "        \"help_text\": null,\n" +
            "        \"display_order\": 0,\n" +
            "        \"short_text\": \"introduction\",\n" +
            "        \"pick\": \"none\",\n" +
            "        \"display_type\": \"intro\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"correct_answer_id\": null,\n" +
            "        \"facebook_profile\": null,\n" +
            "        \"twitter_profile\": null,\n" +
            "        \"image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/2001ebbfdcbf6c00c757_\",\n" +
            "        \"cover_image_url\": \"https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_\",\n" +
            "        \"cover_image_opacity\": 0.6,\n" +
            "        \"cover_background_color\": null,\n" +
            "        \"is_shareable_on_facebook\": false,\n" +
            "        \"is_shareable_on_twitter\": false,\n" +
            "        \"font_face\": null,\n" +
            "        \"font_size\": null,\n" +
            "        \"tag_list\": \"\"\n" +
            "      },\n" +
            "      \"relationships\": {\n" +
            "        \"answers\": {\n" +
            "          \"data\": []\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"54daf66f71cc24161b22\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"8\",\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": null,\n" +
            "        \"short_text\": \"answer_9\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": false,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": false,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 8,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": null,\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"answer\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": 8,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"e68ac9b06cbfce652df1\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"9\",\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": null,\n" +
            "        \"short_text\": \"answer_10\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": false,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": false,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 9,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": null,\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"answer\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": 9,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"3a0961f5c0ac74d62fd3\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"10\",\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": null,\n" +
            "        \"short_text\": \"answer_11\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": false,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": false,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 10,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": null,\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"answer\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": 10,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"2a49e148c5b170aca804\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": null,\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": null,\n" +
            "        \"short_text\": \"answer_1\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": false,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": false,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 0,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": null,\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"text\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": null,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"491d49dd6b8174456acf\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"First Name\",\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": \"John\",\n" +
            "        \"short_text\": \"answer_1\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": true,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": false,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 0,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": null,\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"string\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": null,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"6db6dcae1a6c6644d723\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"Mobile No.\",\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": \"0999999999\",\n" +
            "        \"short_text\": \"answer_5\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": false,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": false,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 1,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": \"\\\\+?[0-9]{6,13}\",\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"string\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": null,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"575db8c074601994bde3\",\n" +
            "      \"type\": \"answer\",\n" +
            "      \"attributes\": {\n" +
            "        \"text\": \"Email \",\n" +
            "        \"help_text\": null,\n" +
            "        \"input_mask_placeholder\": \"you@example.com\",\n" +
            "        \"short_text\": \"answer_6\",\n" +
            "        \"is_mandatory\": false,\n" +
            "        \"is_customer_first_name\": false,\n" +
            "        \"is_customer_last_name\": false,\n" +
            "        \"is_customer_title\": false,\n" +
            "        \"is_customer_email\": true,\n" +
            "        \"prompt_custom_answer\": false,\n" +
            "        \"weight\": null,\n" +
            "        \"display_order\": 2,\n" +
            "        \"display_type\": \"default\",\n" +
            "        \"input_mask\": \"[\\\\.\\\\-_\\\\+a-zA-Z0-9]+@[\\\\-\\\\a-zA-Z0-9]+(?:\\\\.[\\\\-a-zA-Z0-9]+)+\",\n" +
            "        \"date_constraint\": null,\n" +
            "        \"default_value\": null,\n" +
            "        \"response_class\": \"string\",\n" +
            "        \"reference_identifier\": null,\n" +
            "        \"score\": null,\n" +
            "        \"alerts\": []\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}"
}