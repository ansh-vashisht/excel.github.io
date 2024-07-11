<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Excel File</title>
</head>
<body>
    <h2>Upload Excel File</h2>
    <form method="post" action="UploadServlet" enctype="multipart/form-data">
        <input type="file" name="file" accept=".xls,.xlsx,.csv">
        <br><br>
        <input type="submit" value="Upload">
    </form>
</body>
</html>
