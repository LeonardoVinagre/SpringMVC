$(document).ready(function () {
                $("#submit").on('click', function () {
                  var titulo = $("#titulo").val();
                  var post = $("#post").val();

                  $.ajax({
                        url: '/posts',
                        type: "POST",
                        data: $.param({titulo: titulo, post: post}),
                        success: function (data) {
                            console.log("sucesso");
                        }
                    });
                })
            });