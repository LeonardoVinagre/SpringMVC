function deleteComment(commentaryId) {
              $.ajax({
                          url: '/comments',
                          type: "DELETE",
                          dataType: 'json',
                          data: $.param({id: commentaryId}),
                          success: function (data) {
                              location.reload();
                          }
                      });
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
                        <div class="editCom">
                            <button onclick="deleteComment(${comments.id})">Excluir</button>
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
                                  <div>
                                      <button class="hiden" id="save-changes-${post.id}" onclick="saveChanges(${post.id})">Salvar</button>
                                      <button id="edit-button-${post.id}" onclick="editPost(${post.id})">Editar</button>
                                      <button onclick="deletePost(${post.id})">Deletar</button>
                                  </div>
                        </div>`;

                        return postDiv;
            }

            function postBuild(post) {
              var comentariosDiv = buildComentarios(post.comments);
              var postDiv = buildPost(post, comentariosDiv);

              return postDiv;
            }

            function postAdd(post){
                $("#posts").append(
                    postBuild(post));
            }

            function separate(data){
              $.each(data, function(index, post){
                  postAdd(post);
              });
              resizeText();
            }

            $(document).ready(function () {

              $.ajax({
                          url: '/posts/userPosts',
                          type: "GET",
                          dataType: 'json',
                          success: function (data) {

                              separate(data);
                          }
                      });

            });
<!--set text area to auto resize-->
            function resizeText() {
                $("textarea").each(function () {
                    this.setAttribute("style", "height:" + (this.scrollHeight) + "px;overflow-y:hidden;");
                }).on("input", function () {
                    this.style.height = 0;
                    this.style.height = (this.scrollHeight) + "px";
                });
            }


            function editPost(postId) {
                document.getElementById("textarea-"+postId).removeAttribute('readonly');
                document.getElementById("save-changes-"+postId).style.display = 'initial';
                document.getElementById("edit-button-"+postId).style.display = 'none';
            }

            function saveChanges(postId) {
                var newPost = document.getElementById("textarea-"+postId).value;
                console.log("será atualizado!");
                $.ajax({
                          url: '/posts/change',
                          type: "PATCH",
                          data: $.param({id: postId, post: newPost}),
                          success: function (data) {
                              location.reload();
                          }
                      });
            }

            function deletePost(postId) {
                console.log(postId);
                $.ajax({
                          url: '/posts/delete',
                          type: "DELETE",
                          data: $.param({id: postId}),
                          success: function (data) {
                              location.reload();
                          }
                      });
            }