// id를 가진 플레이어 정의
// var player = videojs('my-video');

// 플레이어 정의와 동시에 설정할 수 있음
var player = videojs('my-video', {

  //재생 속도 조절 설정
  playbackRates: [.5, .75, 1, 1.5, 2, 2.5],

  //플레이어 반응형 적용
  fluid: true,

  // options
  plugins: {
    hotkeys: {
      seekStep: 10,
      volume: 10,
      enableNumbers: false
    }
  }
});

// // 플레이어에 키보드 핫 키 적용하기 - 볼륨, 재생 앞 뒤 이동
// player.ready(function () {
//   this.hotkeys({
//     volumeStep: 0.1,
//     seekStep: 15,
//     enableNumbers: false
//   });
// });

// // 재생 끝난 후 플레이어 삭제
// player.on('ended', function () {
//   this.dispose();
// });

// // pause시 남은 시간 알람
// player.on('pause', function () {
//   alert('You have ' + this.remainingTime() + ' left ');
// });

// // 재생 끝난 후 alert
// player.on('ended', function () {
//   alert('video is ended');
// });

// // 3초 후 재생
// player.ready(function () {
//   setTimeout(() => {
//     this.play();
//   }, 3000)
// });
