window.onload = async function () {
    let elem = document.getElementById("add");
    elem.onclick = async function () {
        await fetch("/api/books", {
            method: "POST",
            headers: {"Accept": "application/json", "Content-Type": "application/json"},
            body: JSON.stringify({
                "name": document.getElementById("name").value,
                "genre": document.getElementById("genre").value,
                "took": document.getElementById("took").value,
                "returned": document.getElementById("returned").value
            })
        });
    }
};