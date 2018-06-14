$(document).ready(function () {
    $('#test').click(function () {
        $('.list').empty()
        $.get($(this).attr('data-url'), (res) => {

            console.log(res)
            res.tshirts.forEach((tshirt) => {
                // $('.list').append(`
                // <li class="${tshirt.rarity}"><div class="tshirt-container">
                //   <span class="tshirt-cell" >${tshirt.name}</span>                       
                // </div></li>`)
                const $li = $('<li></li>')
                $li.addClass(tshirt.rarity.toLowerCase())

                $li.append(`<img src="${tshirt.pictureUrl}">`)

                $('.list').append($li)
            })

            $('.window').css({
                right: "0"
            })
            const x = parseInt(res.selected)

            $('.window').animate({
                right: (x * (256 + 8) - 256)
            }, 10000, 'swing', () => {
                $('.list li:eq(' + x + ')').css({
                    border: '8px solid goldenrod'
                })
                setTimeout(() => {
                    alert(`Congratulations! You have won the "${res.tshirts[x].name}"!`)
                    location.replace("/my-tshirts")
                }, 500)           
            })
        }).fail((redirectUrl) => {
            location.replace(redirectUrl.responseText)
        })
    })
});