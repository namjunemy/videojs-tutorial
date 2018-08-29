<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link href="https://vjs.zencdn.net/7.1.0/video-js.css" rel="stylesheet">

  <title>Videojs Tutorial</title>
</head>
<body>
<video id="my-video"
       class="video-js vjs-big-play-centered"
       controls
       poster="http://vjs.zencdn.net/v/oceans.png"
       data-setup="{}">
  <source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">

  <p class="vjs-no-js">
    To view this video please enable JavaScript, and consider upgrading to a web browser that
    <a href="https://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
  </p>
</video>

<script src="https://vjs.zencdn.net/7.1.0/video.js"></script>
<script src="//cdn.sc.gl/videojs-hotkeys/latest/videojs.hotkeys.min.js"></script>
<script src="/js/main.js"></script>
</body>
</html>