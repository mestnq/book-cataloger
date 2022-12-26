window.onload = async function() {
    const response = await fetch("/api/books", {
        method: "GET",
        headers: { "Accept": "application/json", "Content-Type": "application/json" }
    });

    console.log(response);
    console.log(response.ok);
    if (response.ok === true) {
        let books = await response.json();
        console.log(books);

        for (let book of books) {
            append_select(book);
        }
    }
}

function append_select(book) {
    let select = document.getElementById("books-list");
    let option = document.createElement("option");

    option.innerText = `[${book.time}] <${book.name}>: ${book.returned}, ${book.took}`;
    option.value = book.id;

    select.appendChild(option);
}

async function choose_select(id) {
    const response = await fetch(`/api/books/${id.value}`, {
        method: "GET",
        headers: { "Accept": "application/json", "Content-Type": "application/json" }
    });

    console.log(response);
    console.log(response.ok);
    if (response.ok === true) {
        let book = await response.json();
        console.log(book);
        document.getElementById('id').value = book.id;
        document.getElementById('name').value = book.name;
        document.getElementById('took').value = book.took;
        document.getElementById('genre').value = book.genre;
        document.getElementById('returned').value = book.returned;
    }
}