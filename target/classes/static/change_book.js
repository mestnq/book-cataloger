window.onload = async function () {
    const response = await fetch("/api/change", {
        method: "POST",
        headers: { "Accept": "application/json", "Content-Type": "application/json" }
    });

    console.log(response);
    console.log(response.ok);
    if (response.ok === true) {
        let book = await response.json();
        for (let item of book) {
            console.log(item);
        }
    }
}

function append_table_list(task) {
    let table = document.getElementById("tasks");
    let row = document.createElement("tr");

    let name = document.createElement("td");
    name.innerHTML += `${task.name}`;
    row.appendChild(name);

    let desc = document.createElement("td");
    desc.innerHTML += `${task.description}`;
    row.appendChild(desc);

    let time = document.createElement("td");
    time.innerHTML += `${task.time}`;
    row.appendChild(time);

    table.appendChild(row);
}