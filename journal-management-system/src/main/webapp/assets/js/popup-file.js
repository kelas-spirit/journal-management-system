// Basic Feedback Tab from Lesson 2

$(document).ready(function() {
    $('#box_form').dialog({
        autoOpen: false,
        height: 375,
        width: 350,
        modal: true,
        buttons: [
            {
            text: "Cancel",
            click: function() {
                $(this).dialog("close");
            }},
        {
            text: "Submit",
            click: function() {
                $('#zFormer').submit();
            }}
        ]
    });
    $('#clicky').button().click(function(e){
        $('#box_form').dialog('open');
    });
});