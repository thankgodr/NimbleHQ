package com.richard.nimble.feature_survey.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AttributesXX(
    @SerializedName("alerts")
    val alerts: List<Any>,
    @SerializedName("correct_answer_id")
    val correctAnswerId: Any,
    @SerializedName("cover_background_color")
    val coverBackgroundColor: Any,
    @SerializedName("cover_image_opacity")
    val coverImageOpacity: Double,
    @SerializedName("cover_image_url")
    val coverImageUrl: String,
    @SerializedName("date_constraint")
    val dateConstraint: Any,
    @SerializedName("default_value")
    val defaultValue: Any,
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("display_type")
    val displayType: String,
    @SerializedName("facebook_profile")
    val facebookProfile: Any,
    @SerializedName("font_face")
    val fontFace: Any,
    @SerializedName("font_size")
    val fontSize: Any,
    @SerializedName("help_text")
    val helpText: Any,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("input_mask")
    val inputMask: Any,
    @SerializedName("input_mask_placeholder")
    val inputMaskPlaceholder: Any,
    @SerializedName("is_customer_email")
    val isCustomerEmail: Boolean,
    @SerializedName("is_customer_first_name")
    val isCustomerFirstName: Boolean,
    @SerializedName("is_customer_last_name")
    val isCustomerLastName: Boolean,
    @SerializedName("is_customer_title")
    val isCustomerTitle: Boolean,
    @SerializedName("is_mandatory")
    val isMandatory: Boolean,
    @SerializedName("is_shareable_on_facebook")
    val isShareableOnFacebook: Boolean,
    @SerializedName("is_shareable_on_twitter")
    val isShareableOnTwitter: Boolean,
    @SerializedName("pick")
    val pick: String,
    @SerializedName("prompt_custom_answer")
    val promptCustomAnswer: Boolean,
    @SerializedName("reference_identifier")
    val referenceIdentifier: Any,
    @SerializedName("response_class")
    val responseClass: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("short_text")
    val shortText: String,
    @SerializedName("tag_list")
    val tagList: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("twitter_profile")
    val twitterProfile: Any,
    @SerializedName("weight")
    val weight: Any
)