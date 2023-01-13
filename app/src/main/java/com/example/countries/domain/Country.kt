package com.example.countries.domain

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name") var name: String? = null,
    @SerializedName("topLevelDomain") var topLevelDomain: ArrayList<String> = arrayListOf(),
    @SerializedName("alpha2Code") var alpha2Code: String? = null,
    @SerializedName("alpha3Code") var alpha3Code: String? = null,
    @SerializedName("callingCodes") var callingCodes: ArrayList<String> = arrayListOf(),
    @SerializedName("capital") var capital: String? = null,
    @SerializedName("altSpellings") var altSpellings: ArrayList<String> = arrayListOf(),
    @SerializedName("subregion") var subregion: String? = null,
    @SerializedName("region") var region: String? = null,
    @SerializedName("population") var population: Int? = null,
    @SerializedName("latlng") var latlng: ArrayList<Double> = arrayListOf(),
    @SerializedName("demonym") var demonym: String? = null,
    @SerializedName("area") var area: Double? = null,
    @SerializedName("gini") var gini: Double? = null,
    @SerializedName("timezones") var timezones: ArrayList<String> = arrayListOf(),
    @SerializedName("borders") var borders: ArrayList<String> = arrayListOf(),
    @SerializedName("nativeName") var nativeName: String? = null,
    @SerializedName("numericCode") var numericCode: String? = null,
    @SerializedName("flags") var flags: Flags? = Flags(),
    @SerializedName("currencies") var currencies: ArrayList<Currencies> = arrayListOf(),
    @SerializedName("languages") var languages: ArrayList<Languages> = arrayListOf(),
    @SerializedName("translations") var translations: Translations? = Translations(),
    @SerializedName("flag") var flag: String? = null,
    @SerializedName("regionalBlocs") var regionalBlocs: ArrayList<RegionalBlocs> = arrayListOf(),
    @SerializedName("cioc") var cioc: String? = null,
    @SerializedName("independent") var independent: Boolean? = null
)

data class Flags(
    @SerializedName("svg") var svg: String? = null,
    @SerializedName("png") var png: String? = null
)

data class Currencies(
    @SerializedName("code") var code: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("symbol") var symbol: String? = null
)

data class Languages(
    @SerializedName("iso639_1") var iso6391: String? = null,
    @SerializedName("iso639_2") var iso6392: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("nativeName") var nativeName: String? = null
)

data class Translations(
    @SerializedName("br") var br: String? = null,
    @SerializedName("pt") var pt: String? = null,
    @SerializedName("nl") var nl: String? = null,
    @SerializedName("hr") var hr: String? = null,
    @SerializedName("fa") var fa: String? = null,
    @SerializedName("de") var de: String? = null,
    @SerializedName("es") var es: String? = null,
    @SerializedName("fr") var fr: String? = null,
    @SerializedName("ja") var ja: String? = null,
    @SerializedName("it") var it: String? = null,
    @SerializedName("hu") var hu: String? = null
)

data class RegionalBlocs(
    @SerializedName("acronym") var acronym: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("otherNames") var otherNames: ArrayList<String> = arrayListOf()
)