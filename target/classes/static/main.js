window.onload = async function () {
    const response = await fetch("/api/books", {
        method: "GET",
        headers: {"Accept": "application/json", "Content-Type": "application/json"}
    });

    console.log(response);
    console.log(response.ok);
    if (response.ok === true) {
        let books = await response.json();
        console.log(books);

        for (let book of books) {
            add_book(book);
        }
    }

    function add_book(book) {
        let books = document.getElementById("books");
        let row = document.createElement("tr");

        let name = document.createElement("td");
        name.innerHTML += `${book.name}`;
        row.appendChild(name);

        let desc = document.createElement("td");
        desc.innerHTML += `${book.genre}`;
        row.appendChild(desc);

        let desc1 = document.createElement("td");
        desc1.innerHTML += `${book.took}`;
        row.appendChild(desc1);

        let ret = document.createElement("td");
        ret.innerHTML += `${book.returned}`;
        row.appendChild(ret);

        books.appendChild(row);
    }
}