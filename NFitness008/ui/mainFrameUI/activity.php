<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!--    自定义样式-->
    <link rel="stylesheet" href="../../css/homeStyle.css">
    <script src="../../js/Chart.js"></script>
</head>
<body>
<div style="width:30%">
    <div>
        <canvas id="myChart" width="400" height="400"></canvas>
    </div>
</div>



<script>
    var data = {
        labels : ["January","February","March","April","May","June","July"],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#fff",
                data : [65,59,90,81,56,55,40]
            },
            {
                fillColor : "rgba(151,187,205,0.5)",
                strokeColor : "rgba(151,187,205,1)",
                pointColor : "rgba(151,187,205,1)",
                pointStrokeColor : "#fff",
                data : [28,48,40,19,96,27,100]
            }
        ]
    }


    function printChart(){
        var ctx = document.getElementById("myChart").getContext("2d");
        var myNewChart = new Chart(ctx);
        window.myLine =myNewChart.Line(data, {
            responsive: true
        });
    }


</script>


</body>
</html>