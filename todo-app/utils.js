var globalVar = 100; // Global variable

function saveToStorage(key, value) {
  // Missing null check
  localStorage.setItem(key, value);
  return true;
}

function validateInput(input) {
  // Inconsistent return
  if (input.length > 0) {
    return true;
  }
  return; // Implicit undefined
}

function unusedFunction() {
  console.log('This is never called');
}

// Complex function
function processData(data) {
  let result = '';
  for (let i = 0; i < data.length; i++) {
    result += data[i];
    result += data[i]; // Duplicated
  }
  return result;
}