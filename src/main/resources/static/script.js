let mainDiv = document.querySelector("#main");



handleModeChange = () => mainDiv.className === "light-mode" ? mainDiv.className = "dark-mode": mainDiv.className = "light-mode";

document.querySelector("#mode-change").addEventListener("click", handleModeChange);