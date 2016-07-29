console.log("test")
$(function() {
    $("#data_upload_form").submit(function(event) {
        event.preventDefault();

        var ajaxUrl = "/file/upload?";

        ajaxUrl += "filetype=" + $("#select_file_type option:selected").val();

        if(window.FormData) {
            var formData = new FormData($(this)[0]);

            $.ajax({
                type: "POST",
                url: ajaxUrl,
                dataType: "text",
                data: formData,
                processData: false,
                contentType: false,
            }).done(function(data) {
                alert("アップロードが完了しました。");
                var link = '<a id="imgLink" href="/uploadfile/' + data.toString() + '"/>';
                var img = '<img src = "/thumbnail/' + data.toString() + '"/>'
                $("#upload_file").after(link);
                $("#imgLink").append(img);
            }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
                alert("アップロードに失敗しました。");
            });
        } else {
            alert("アップロードに対応できないブラウザです。");
        }
    });
});