# HotSaleTags 
最新版本    [![](https://jitpack.io/v/tanghongxiang/HotSaleTags.svg)](https://jitpack.io/#tanghongxiang/HotSaleTags)

## 效果图
![](https://raw.githubusercontent.com/tanghongxiang/HotSaleTags/master/app/src/main/res/mipmap-xxxhdpi/displayimg.png)



## 属性方法参考

| Attribute                     | Meaning                               | Format  |
| ------------                  |---------------                        | --------|
| HotSaleViewHeight             | HotSaleView的高度                      | dimension |
| LeftBlockWidth                | LeftBlock的宽度                        | dimension |
| LeftBlockMMColorGrad          | LeftBlock背景是否渐变(2种颜色，上下渐变) | boolean   |
| LeftBlockBGColor              | LeftBlock单一背景色                    |  color     |
| LeftBlockMMColorGradTop       | LeftBlockTop渐变背景色                 |  color     |
| LeftBlockMMColorGradBottom    | LeftBlockBottom渐变背景色              |  color     |
| LeftTextColor                 | LeftBlock中文字颜色                    |  color     |
| LeftTextSize                  | LeftBlock中文字大小                    |  dimension |
| LeftTextContent               | LeftBlock中文字内容                    |  String    |
| BlockMargin                   | 左右block的间距                        |  dimension |
| RightBlockWidth               | RightBlock宽度                        |  dimension  |
| RightBlockMMColorGrad         | RightBlock背景是否渐变(2种颜色，上下渐变)|  boolean   |
| RightBlockBGColor             | RightBlock单一背景色                   |  color     |
| RightBlockMMColorGradTop      | RightBlockTop渐变色                    |  color     |
| RightBlockMMColorGradBottom   | RightBlockBottom渐变色                 |  color     |
| RightTextColor                | RightBlock中文字颜色                   |  color     |
| RightTextSize                 | RightBlock中文字大小                   |  dimension |
| RightTextContent              | RightBlock中文字内容                   |  String    |
| HotSaleViewStartRadius        | 左上角Radius                           |  dimension |
| HotSaleViewEndRadius          | 右下角Radius                           |  dimension |
| CanShowRightBlock             | 是否显示RightBlock                     |  boolean   |

目前代码中只提供如下set属性：

| method                | Meaning            | Format  |
| ------------          |---------------     | --------|
| setLeftBlockText      | LeftBlock文字      | Spanned |
| setRightBlockText     | RightBlock文字     | String |
| setCanShowRightBlock  | 是否显示RightBlock | boolean |



# How to To get a Git project into your build?

## Gradle
> Step 1. Add the JitPack repository to your build file
> Add it in your root build.gradle at the end of repositories:
```
  	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
> Step 2. Add the dependency
```
  	dependencies {
	        implementation 'com.github.tanghongxiang:HotSaleTags:v1.0.0'
	}
```

## Maven
> Step 1. Add the JitPack repository to your build file
```
  <repositories>
    <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
    </repository>
  </repositories>
```
> Step 2. Add the dependency
```
  <dependency>
    <groupId>com.github.tanghongxiang</groupId>
    <artifactId>HotSaleTags</artifactId>
    <version>v1.0.0</version>
  </dependency>
```
