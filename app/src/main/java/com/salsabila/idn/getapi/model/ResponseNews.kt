package com.salsabila.idn.getapi.model

import com.google.gson.annotations.SerializedName

data class ResponseNews(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("nextPage")
	val nextPage: Any? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ResultsItem(

	@field:SerializedName("country")
	val country: List<String?>? = null,

	@field:SerializedName("creator")
	val creator: List<String?>? = null,

	@field:SerializedName("keywords")
	val keywords: List<String?>? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("pubDate")
	val pubDate: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("video_url")
	val videoUrl: Any? = null,

	@field:SerializedName("source_id")
	val sourceId: String? = null,

	@field:SerializedName("category")
	val category: List<String?>? = null
)
