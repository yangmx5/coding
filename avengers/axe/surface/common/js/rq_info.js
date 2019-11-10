function main() {
    console.log("main start");
    set_mapping();
    set_queues();
    set_workers();
    $(document).ready(function () {
        setInterval("set_mapping()", 5000);
        setInterval("set_queues()", 2000);
        setInterval("set_workers()", 2000);
    });
    // set_mapping();
}

function set_mapping() {
    var request = $.ajax({
        url: "get_title",
        dataType: "json",
    });
    request.done(function (msg) {
        var rq_title = document.getElementById("rq_title");
        var rq_maps = document.getElementById("rq_maps");
        while (rq_title.hasChildNodes()) {
            rq_title.removeChild(rq_title.firstChild);
        }
        var example = document.createElement("li");
        example.className = "nav-item active";
        example.innerHTML = "<a class=\"nav-link\" href=\"#tab1\" data-toggle=\"pill\">Example</a>";
        rq_title.appendChild(example);
        for (var map in msg) {
            //construct map title
            var li = document.createElement("li");
            li.className = "nav-item";
            var name = map;
            if (map.length > 50) {
                name = map.substring(0, 47) + "...";
            }
            li.innerHTML = "<a class='nav-link' href=\"#" + map + "\" data-toggle=\"pill\">" + name + "</a>";
            rq_title.appendChild(li);

            //construct queues cards
            var queues = document.createElement("div");
            queues.className = "container";
            queues.id = "queues";
            var tmp_count = 0;
            var queue_row = null;
            for (var queue in msg[map]["queues"]) {
                if (tmp_count % 3 === 0) {
                    if (queue_row !== null) {
                        queues.appendChild(queue_row);
                    }
                    queue_row = document.createElement("div");
                    queue_row.className = "row align-items-start row-margin-top";
                }
                var col = document.createElement("div");
                col.id = queue;
                col.className = "col col-4";
                var inner_html = "<div class=\"card\" id=\"" + msg[map]["queues"][queue] + "\">\n" +
                    "<div class='card-header'><h5 class=\"card-title\">" + msg[map]["queues"][queue] + "</h5></div>\n" +
                    "<div class=\"card-body text-secondary\"><p class=\"card-text\">None</p>\n" +
                    "</div></div>";
                col.innerHTML = inner_html;
                queue_row.appendChild(col);
                tmp_count++;
            }
            queues.appendChild(queue_row);

            // construct workers cards
            var workers = document.createElement("div");
            workers.className = "container";
            workers.id = "workers";
            var count = 0;
            var dialog_row = null;
            for (var worker in msg[map]["workers"]) {
                if (count % 3 === 0) {
                    if (dialog_row !== null) {
                        workers.appendChild(dialog_row);
                    }
                    dialog_row = document.createElement("div");
                    dialog_row.className = "row align-items-start row-margin-top";
                }
                var dialog_col = document.createElement("div");
                dialog_col.id = worker;
                dialog_col.className = "col col-4";
                var html = "<div class=\"card\" id=\"" + msg[map]["workers"][worker] + "\">\n" +
                    "<div class='card-header'> <h5 class=\"card-title\">" + msg[map]["workers"][worker] + "</h5></div>\n" +
                    "<div class=\"card-body text-secondary\"><p class=\"card-text\">None</p>\n" +
                    "</div></div>";
                dialog_col.innerHTML = html;
                dialog_row.appendChild(dialog_col);
                count++;
            }
            if (dialog_row !== null) {
                workers.appendChild(dialog_row);
            }


            var tab_pane = document.createElement("div");
            tab_pane.className = "tab-pane";
            tab_pane.id = map;
            var split = document.createElement("hr");
            tab_pane.appendChild(queues);
            tab_pane.appendChild(split);
            tab_pane.appendChild(workers);
            rq_maps.appendChild(tab_pane);
            // set_queues();
            // set_workers();
        }
    });
    request.fail(function (jqXHR, textStatus) {
        console.log(textStatus)
    });
}

function set_queues() {
    console.log("set_queues");
    var request = $.ajax({
        url: "get_queues",
        dataType: "json",
    });
    request.done(function (msg) {
        console.log(msg);
        for (var queue in msg) {
            var card = document.getElementById(queue);
            if (card !== null) {
                var text = card.getElementsByTagName("p")[0];
                var old_value = text.title;
                var speed = (msg[queue] - old_value) / 2;
                text.title = msg[queue];
                text.innerHTML = "<b>length</b>: " + msg[queue] + "<br><b>speed</b>: " + speed + " items/s<br><a name=\"" + queue + "\" href=\"#\" style=\"float:right;\" class=\"card-link\"\n" +
                    "                                       onclick=\"set_jobs_detail_modal(this)\"\n" +
                    "                                       data-toggle=\"modal\"\n" +
                    "                                       data-target=\"#queue_jobs\">Jobs</a>";
            }
        }
    });
    request.fail(function (jqXHR, textStatus) {
        console.log(textStatus)
    });
}

function set_workers() {
    console.log("set_workers");
    var request = $.ajax({
        url: "get_workers",
        dataType: "json",
    });
    request.done(function (msg) {
        console.log(msg);
        for (var worker in msg) {
            var card = document.getElementById(worker);
            if (card !== null) {
                var text = card.getElementsByTagName("p")[0];
                var title = card.getElementsByTagName("h5")[0];
                title.innerHTML = msg[worker]["name"];
                text.innerHTML = "<b>current_job</b>: " + "<a href=\"\" onclick=\"set_detail_modal(this)\" data-toggle=\"modal\"data-target=\"#job_detail\">" + msg[worker]["current_job"] + "</a>" +
                    "<br><b>state</b>: " + msg[worker]["state"] +
                    "<br><b>failed_job_count</b>: " + msg[worker]["failed_job_count"] +
                    "<br><b>successful_job_count</b>: " + msg[worker]["successful_job_count"] +
                    "<br><b>total_working_time</b>: " + msg[worker]["total_working_time"] +
                    "<br><b>last_heartbeat</b>: " + msg[worker]["last_heartbeat"] +
                    "<br><b>birth_date</b>: " + msg[worker]["birth_date"];
            }
        }
    })
}

function set_detail_modal(obj, is_fail = 0) {
    var job_id = obj.innerText;
    var title = document.getElementById("job_detail_title");
    var modal = document.getElementById("job_detail_body");
    title.innerHTML = job_id;
    var request = $.ajax({
        url: "get_job_info/" + job_id,
        dataType: "json",
    });
    request.done(function (msg) {
        if (msg["id"] !== null && msg["id"] === job_id) {
            modal.innerHTML = "<b>func_name</b>: " + msg["func_name"] +
                "<br><b>status</b>: " + msg["status"] +
                "<br><b>origin</b>: " + msg["origin"] +
                "<br><b>args</b>: " + msg["args"] +
                "<br><b>kwargs</b>: " + msg["kwargs"] +
                "<br><b>created_at</b>: " + msg["created_at"] +
                "<br><b>started_at</b>: " + msg["started_at"] +
                "<br><b>enqueued_at</b>: " + msg["enqueued_at"] +
                "<br><b>timeout</b>: " + msg["timeout"] +
                "<br><b>instance</b>: " + msg["instance"] +
                "<br><b>result</b>: " + msg["result"] +
                "<br><b>description</b>: " + msg["description"] +
                "<br><b>exec_info</b>: " + msg["exec_info"] + "<br>";
            if (is_fail) {
                modal.innerHTML += "<a href='#' onclick=\'requeue_failed_job(\"" + job_id
                    + "\")\' style='float:right'>requeue</a><br><a href='#' onclick=\'cancel_failed_job(\"" + job_id + "\")\'  style='float:right'>cancel</a> "
            }
        } else {
            modal.innerHTML = "get the job info failed";
        }
    });
}

function set_jobs_detail_modal(obj) {
    var queue_name = obj.name;
    var request = $.ajax({
        url: "get_finished_job_ids/" + queue_name,
        dataType: "json",
    });
    var modal = document.getElementById("jobs_content");
    var fail_modal = document.getElementById("failed_jobs_content");
    request.done(function (msg) {
        if (msg["name"] !== null && msg["name"] === queue_name) {
            var html = "";
            for (var id in msg["job_ids"]) {
                var text = msg["job_ids"][id];
                html += "<a href=\"\" onclick=\"set_detail_modal(this)\" data-toggle=\"modal\"data-target=\"#job_detail\">" + text + "</a><br>";
                // html += msg["job_ids"][id] + "<br>";
            }
            if (msg["job_ids"].length === 0) {
                html = "no finished job. finished job only kept 500 seconds in default"
            }
            modal.innerHTML = html
        } else {
            modal.innerHTML = "get job ids failed";
        }
    });

    var fail_request = $.ajax({
        url: "get_failed_job_ids/" + queue_name,
        dataType: "json",
    })

    fail_request.done(function (msg) {
        if (msg["name"] !== null && msg["name"] === queue_name) {
            var html = "";
            for (var id in msg["job_ids"]) {
                var text = msg["job_ids"][id];
                html += "<a href=\"\" onclick=\"set_detail_modal(this,1)\" data-toggle=\"modal\"data-target=\"#job_detail\">" + text + "</a><br>";
            }
            if (msg["job_ids"].length === 0) {
                html = "Jobs that do not fail may be blocked by failed tasks in other queues. We only show the top 3000 failed jobs"
            }
            fail_modal.innerHTML = html
        } else {
            fail_modal.innerHTML = "get failed job ids failed";
        }
    })

}

function requeue_failed_job(job_id) {
    var request = $.ajax({
        url: "requeue_failed_job/" + job_id,
        dataType: "json",
    });
    request.done(function (msg) {
        console.log("requeue the fail job");
        console.log(msg)
    })
}

function cancel_failed_job(job_id) {
    var request = $.ajax({
        url: "cancel_failed_job/" + job_id,
        dataType: "json",
    });
    request.done(function (msg) {
        console.log("cancel kthe fail job");
        console.log(msg)
    })
}
