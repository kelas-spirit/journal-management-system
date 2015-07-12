function go(url)
{
    window.location = url;
}

function deleteDocument(url)
{
    var isOK = confirm("Are you sure you want to delete Document ?\nThis action can not be reversed.");
    if(isOK)
    {
        go(url);
    }
}

function deleteRole(url)
{
    var isOK = confirm("Are you sure you want to delete this role ?\nThis action can not be reversed.");
    if(isOK)
    {
        go(url);
    }
}

function unscribe(url)
{
    var isOK = confirm("Are you sure you want to unscribe this magazine?\nThis action can not be reversed.");
    if(isOK)
    {
        go(url);
    }
}
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}