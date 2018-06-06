$(document).ready(function () {
    $('#test').click(function() {
        $('.list').empty()
        $.get($(this).attr('data-url'), (res) => {
            res.tshirts.forEach((tshirt) => {
                $('.list').append(`
                <li><div class="tshirt-container">
                  <span class="tshirt-cell" >${tshirt.name}</span>                       
                </div></li>`)
            })

            $('.window').css({
                right: "0"
            })
            $('.list li').css({
                border: '4px solid #fff'
            })
            const x = parseInt(res.selected)
            $('.list li:eq('+x+')').css({
                border:'4px solid #00ba00'
            })
            $('.window').animate({
                right: (x*(130 + 16) - 145)
            }, 10000)
        })
    })
});