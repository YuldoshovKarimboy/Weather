package com.example.myapplication.core.model
import com.google.gson.annotations.SerializedName

data class FiveDailyForecast(
    @SerializedName("Headline")
    val headline: Headline,
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecast>
) {
    data class Headline(
        @SerializedName("EffectiveDate")
        val effectiveDate: String, // 2021-12-11T07:00:00+05:00
        @SerializedName("EffectiveEpochDate")
        val effectiveEpochDate: Int, // 1639188000
        @SerializedName("Severity")
        val severity: Int, // 3
        @SerializedName("Text")
        val text: String, // Expect showers Saturday morning
        @SerializedName("Category")
        val category: String, // rain
        @SerializedName("EndDate")
        val endDate: String, // 2021-12-11T13:00:00+05:00
        @SerializedName("EndEpochDate")
        val endEpochDate: Int, // 1639209600
        @SerializedName("MobileLink")
        val mobileLink: String, // http://www.accuweather.com/en/uz/navoiy/355115/daily-weather-forecast/355115?unit=c&lang=en-us
        @SerializedName("Link")
        val link: String // http://www.accuweather.com/en/uz/navoiy/355115/daily-weather-forecast/355115?unit=c&lang=en-us
    )

    data class DailyForecast(
        @SerializedName("Date")
        val date: String, // 2021-12-11T07:00:00+05:00
        @SerializedName("EpochDate")
        val epochDate: Int, // 1639188000
        @SerializedName("Temperature")
        val temperature: Temperature,
        @SerializedName("Day")
        val day: Day,
        @SerializedName("Night")
        val night: Night,
        @SerializedName("Sources")
        val sources: List<String>,
        @SerializedName("MobileLink")
        val mobileLink: String, // http://www.accuweather.com/en/uz/navoiy/355115/daily-weather-forecast/355115?day=1&unit=c&lang=en-us
        @SerializedName("Link")
        val link: String // http://www.accuweather.com/en/uz/navoiy/355115/daily-weather-forecast/355115?day=1&unit=c&lang=en-us
    ) {
        data class Temperature(
            @SerializedName("Minimum")
            val minimum: Minimum,
            @SerializedName("Maximum")
            val maximum: Maximum
        ) {
            data class Minimum(
                @SerializedName("Value")
                val value: Double, // 0.8
                @SerializedName("Unit")
                val unit: String, // C
                @SerializedName("UnitType")
                val unitType: Int // 17
            )

            data class Maximum(
                @SerializedName("Value")
                val value: Int, // 12
                @SerializedName("Unit")
                val unit: String, // C
                @SerializedName("UnitType")
                val unitType: Int // 17
            )
        }

        data class Day(
            @SerializedName("Icon")
            val icon: Int, // 12
            @SerializedName("IconPhrase")
            val iconPhrase: String, // Showers
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean, // true
            @SerializedName("PrecipitationType")
            val precipitationType: String, // Rain
            @SerializedName("PrecipitationIntensity")
            val precipitationIntensity: String // Moderate
        )

        data class Night(
            @SerializedName("Icon")
            val icon: Int, // 35
            @SerializedName("IconPhrase")
            val iconPhrase: String, // Partly cloudy
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean, // false
            @SerializedName("PrecipitationType")
            val precipitationType: String, // Rain
            @SerializedName("PrecipitationIntensity")
            val precipitationIntensity: String // Moderate
        )
    }
}