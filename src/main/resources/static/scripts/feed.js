$(document).ready(function () {

                      $.ajax({
                          url: '/posts',
                          type: "GET",
                          dataType: 'json',
                          success: function (data) {

                              separate(data);
                          }
                      });

            });

            function separate(data){
              $.each(data, function(index, post){
                  postAdd(post);
              });
              resizeText();
            }

            function postAdd(post){
                console.log("chego");
                $("#posts").append(
                    postBuild(post));
            }

            function postBuild(post) {
              var comentariosDiv = buildComentarios(post.comments);
              var postDiv = buildPost(post, comentariosDiv);

              return postDiv;
            }

            function buildComentarios(comments) {
              var comentariosDiv = ``;
              $.each(comments, function(index, comments){
                comentariosDiv += `
                    <div class="comentario">
                        <div class="tituloCom">
                            ${comments.nome_autor}
                        </div>
                        <div class="com">
                            ${comments.comentario}
                        </div>

                    </div>
                `;
              });
              return comentariosDiv;
            }

            function buildPost(post, comentariosDiv) {
                var postDiv =
                          `<div id="post" class="mb-3">
                              <div class="text-center">
                                  <div class="row">
                                      <div>
                                          Autor: ${post.autor}
                                      </div>
                                      <div>
                                          Titulo: ${post.titulo}
                                      </div>
                                  </div>
                                  <hr size="50" width="50%" align="center" noshade >
                                  <div class="row">
                                      <div>
                                          <textarea class="textarea" id="textarea-${post.id}" readOnly>${post.post}</textarea>
                                      </div>
                                  </div>
                                  <br>
                                  <div class="comentarios" id="comentarios">
                                    ${comentariosDiv}
                                  </div>
                                      <textarea class="textarea hiden" id="newCommentText-${post.id}" placeholder="Insira seu comentario"></textarea>
                                  <div>
                                      <button class="addComment-button" id="add-comment-${post.id}" onclick="newComment(${post.id})">Novo Comentario</button>
                                      <button class="hiden" id="save-comment-${post.id}" onclick="saveComment(${post.id})">Salvar comentario</button>
                                  </div>
                        </div>`;

                        return postDiv;
            }

            function resizeText() {
                $("textarea").each(function () {
                    this.setAttribute("style", "height:" + (this.scrollHeight) + "px;overflow-y:hidden;");
                }).on("input", function () {
                    this.style.height = 10;
                    this.style.height = (this.scrollHeight) + "px";
                });
            }

            function newComment(postId) {
                document.getElementById("newCommentText-"+postId).classList.remove("hiden");
                document.getElementById("newCommentText-"+postId).style.height = "25px";
                document.getElementById("save-comment-"+postId).classList.remove("hiden");
                document.getElementById("add-comment-"+postId).classList.add("hiden");
            }

            function saveComment(postId) {
                var newComment = document.getElementById("newCommentText-"+postId).value;

                $.ajax({
                      url: '/comments',
                      type: "POST",
                      data: $.param({idPost: postId, comentario: newComment}),
                      success: function (data) {
                          location.reload();
                      }
                });
            }