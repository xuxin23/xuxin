/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	config.language = 'zh-cn';
	config.filebrowserBrowseUrl = 'ckeditor/uploader/browse.jsp';
	config.filebrowserImageBrowseUrl = 'ckeditor/uploader/browse.jsp?type=Images';
	config.filebrowserFlashBrowseUrl = 'ckeditor/uploader/browse.jsp?type=Flashs';
	config.filebrowserUploadUrl = 'ckeditor/uploader/upload.jsp';
	config.filebrowserImageUploadUrl = 'ckeditor/uploader/upload.jsp?type=Images';
	config.filebrowserFlashUploadUrl = 'ckeditor/uploader/upload.jsp?type=Flashs';
	config.filebrowserWindowWidth = '640';
	config.filebrowserWindowHeight = '480';
	config.width='640';
	config.height='480';
	config.MaxSize = 0 ;
}
