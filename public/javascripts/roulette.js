$(document).ready(function () {
    $('.button').click(function () {
        $.get($(this).attr('data-url'), (res) => {
            console.log(res)
            $('.window').css({
                right: "0"
            })
            $('.list li').css({
                border: '4px solid #fff'
            })
            const x = parseInt(res);
            $('.list li:eq('+x+')').css({
                border:'4px solid #00ba00'
            })
            $('.window').animate({
                right: (x*(130 + 16) - 130)
            }, 10000);
        })
    });
});