# Horizontal Stacked Bar View

<a href="https://www.android.com"><img src="https://img.shields.io/badge/platform-Android-yellow.svg" alt="platform"/></a>
<a href="https://android-arsenal.com/api?level=21"><img src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat" alt="API"/></a>
<a href="https://jitpack.io/#MugdhaRahman/horizontalstackedbarview"><img src="https://jitpack.io/v/MugdhaRahman/horizontalstackedbarview.svg" alt="JitPack"></a>
<a href="https://github.com/MugdhaRahman/horizontalstackedbarview/blob/master/LICENSE"><img src="https://img.shields.io/github/license/ahmmedrejowan/DeviceInfo" alt="GitHub license"/></a>


 <img src="https://github.com/MugdhaRahman/horizontalstackedbarview/assets/113788414/86baed63-cddb-4b0b-8df8-0c1ae0428dfa" width = "100" height = "100" alt=""/>

 <h3>A customizable and easy-to-use Horizontal and Vertical Stacked Bar library for Android<b></b></h3>

  <p> <a href="https://github.com/MugdhaRahman/horizontalstackedbarview/issues"><img src="https://img.shields.io/github/issues/MugdhaRahman/horizontalstackedbarview" alt="GitHub issues"></a>
   <a href="https://github.com/MugdhaRahman/horizontalstackedbarview/network"><img src="https://img.shields.io/github/forks/MugdhaRahman/horizontalstackedbarview" alt="GitHub forks"></a> 
   <a href="https://github.com/MugdhaRahman/horizontalstackedbarview/stargazers"><img src="https://img.shields.io/github/stars/MugdhaRahman/horizontalstackedbarview" alt="GitHub stars"></a> 
   <a href="https://github.com/MugdhaRahman/horizontalstackedbarview/graphs/contributors"> <img src="https://img.shields.io/github/contributors/MugdhaRahman/horizontalstackedbarview" alt="GitHub contributors"></a>  </p>

 ## Feature

   - Support for both horizontal and vertical orientations

   - Customizable bar colors and corner radius

   - Seamless integration with LegendView for displaying legends

   - Legends support for both horizontal and vertical orientations

   - highly customizable legends 

   - Lightweight and highly configurable


## Demo

|horizontal|`vertical`|
|---|---|
| ![shot1](https://github.com/MugdhaRahman/horizontalstackedbarview/assets/113788414/c635cebd-4636-4fd7-8807-59f731e12d0c) | ![shot2](https://github.com/MugdhaRahman/horizontalstackedbarview/assets/113788414/961bc7fe-2d71-424e-b53d-70dc5a128b39)


## Installation

#### Kotlin DSL


``` Kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven{
            url = uri("https://jitpack.io")
        }
    }
}
```

#### Groovy



``` groovy
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```



## Dependency
Add this to your module's `build.gradle.kts` file (latest version <a href="https://jitpack.io/#MugdhaRahman/horizontalstackedbarview"><img src="https://jitpack.io/v/MugdhaRahman/horizontalstackedbarview.svg" alt="JitPack"></a>):

#### Kotlin DSL

``` kotlin
dependencies {
    ...
    implementation("com.github.MugdhaRahman:horizontalstackedbarview:0.2")
}
```

#### Groovy

``` groovy
dependencies {
    ...
	        implementation 'com.github.MugdhaRahman:horizontalstackedbarview:0.2'
}
```

## Usage

#### Basic Setup


### xml

Add `HorizontalStackedBarChartView` and `LegendView` to your layout XML:

``` XML 
<com.mrapps.horizontalstackedbarview.HorizontalStackedBarChartView
    android:id="@+id/barChartView"
    android:layout_width="match_parent"
    android:layout_height="200dp"
    android:layout_margin="10dp"
    app:barColor="@color/yourBarColor"
    app:barCornerRadius="10dp"
    app:orientation="horizontal" /> <!--use vertical orientation for vertical bar -->

<com.mrapps.horizontalstackedbarview.LegendView
    android:id="@+id/legendView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp" />

```

#### Initialize and Add Data in Kotlin

### kotlin

```kotlin

    private val people = 50.00
    private val animal = 100.25
    private val trees = 110.50
    private val ocean = 200.20
    private val zombies = 30.00
    private val aliens = 40.00

    val barchartView = findViewById<HorizontalStackedBarChartView>(R.id.barChartView)
    val legendView = findViewById<LegendView>(R.id.legendView)

    barchartView.addData(1, people, getColor(R.color.purple_500), "People") // add the color values
    barchartView.addData(2, animal, getColor(R.color.purple_200), "Animal")
    barchartView.addData(3, trees, getColor(R.color.green), "Trees")
    barchartView.addData(4, ocean, getColor(R.color.blue), "Ocean")
    barchartView.addData(5, zombies, getColor(R.color.red), "Zombies")
    barchartView.addData(6, aliens, getColor(R.color.maroon), "Aliens")

    barChartView.setLegendView(legendView) // for legend data

```

#### Legend Customization

```kotlin

legendView.setLegendHorizontal = true // Set to false for vertical legends
legendView.setHorizontalSpanCount = 2 // Number of columns in horizontal layout
legendView.legendTextColor = ContextCompat.getColor(this, R.color.default_legend_text_color)
legendView.legendValueTextColor = ContextCompat.getColor(this, R.color.default_legend_sub_text_color)
legendView.legendTextSize = 15.5f // Text size for legend labels
legendView.legendValueTextSize = 12.5f // Text size for legend values
legendView.legendDotHeight = 35f // Height of the legend dots
legendView.legendDotWidth = 35f // Width of the legend dots
legendView.legendDotCornerRadius = 8f // Corner radius for the legend dots
legendView.legendDotSpacing = 20.9f // Spacing between legend dots
legendView.legendValueSpacing = 21.2f // Spacing between legend values
legendView.legendItemSpace = 40.5f // Spacing between legend iteam
legendView.legendValue = true // Set to false for percent value
legendView.legendValueShow = true // Show/hide legend values
legendView.legendTextStyle = DefaultLegendTextStyle // Legend text style
legendView.legendValueTextStyle = DefaultLegendValueTextStyle // Legend value text style

```

## Contributing

Please fork this repository and contribute back using [pull requests](https://github.com/MugdhaRahman/horizontalstackedbarview/pulls).

Any contributions are welcome! Please feel free to submit a pull request or open an issue.


Let me know which features you want in the future in `Request Feature` tab.

If this project helps you a little bit, then give a Star ⭐ the Repo.


## Notes
- The library is in its early stages, so there may be some bugs.
- If you find any bugs, please report them in the `Issues` tab.
- Sample app is available in the [app](https://github.com/MugdhaRahman/horizontalstackedbarview/tree/master/app/build/outputs/apk/debug) directory.


## License
* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2024 Mugdharahman

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
