# Adrian's Profile Image

<img align="right" src="./Python/profile-image.png" alt="alt text" width="100px" height="100px"></img>

This repository contains the code that was used to generate my profile image. 
The image you see here is a remake of the [figure][2] by [Claudio Rocchini][3] shown in the Wikipedia article on [Complex Analysis][1].

## Java

This is the original code from when I was in high school.

## Python

The code is written in Python 3. Install the requirements with 

``` 
pip install -r requirements.txt
```
To convert the generated frames to a GIF, we additinally require [ImageMagick][4]:
```
convert -delay 5 -loop 0 animation/*.png profile-image.gif
```

[1]: https://en.wikipedia.org/wiki/Complex_analysis
[2]: https://en.wikipedia.org/wiki/Complex_analysis#/media/File:Color_complex_plot.jpg
[3]: https://en.wikipedia.org/wiki/User:Rocchini
[4]: https://imagemagick.org/script/download.php
