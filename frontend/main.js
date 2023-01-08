let convertButton = document.getElementById("convert");
let inputFieldAmount = document.getElementById("inputFieldAmount");
let inputFieldFrom = document.getElementById("inputFieldFrom");
let inputFieldTo = document.getElementById("inputFieldTo");
let result = document.getElementById("result");

convertButton.addEventListener("click", function () {
  const amount = inputFieldAmount.value;
  const from = inputFieldFrom.value;
  const to = inputFieldTo.value;

  fetch(
    `http://localhost:8080/api/v1/converter/from/${from}/to/${to}/quantity/${amount}`,
    {
      method: "get",
      headers: {
        "Content-Type": "application/json",
      },
    }
  )
    .then((response) => response.json())
    .then((data) => {
      console.log("response: " + data);
      result.innerHTML = `${amount} ${from} is worth ${data.toFixed(2)} ${to}`;
    });
});
