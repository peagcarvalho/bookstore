"use strict";

document.getElementById("searchButton").addEventListener("click", function () {
  const busca = document.getElementById("searchInput").value;

  document.getElementById("searchButton").href = "/buscaLivro/" + busca;
});

document
  .getElementById("searchInput")
  .addEventListener("keydown", function (event) {
    if (event.key === "Enter") {
      const busca = document.getElementById("searchInput").value;

      document.getElementById("searchButton").href = "/buscaLivro/" + busca;

      document.getElementById("searchButton").click();
    }
  });
