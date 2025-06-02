function addTodo() {
  let task = document.getElementById('todo-input').value;
  let list = document.getElementById('todo-list');
  // Vulnerable to XSS
  list.innerHTML += '<li>' + task + ' <button onclick="deleteTodo(this)">Delete</button></li>';
  
  // Long function with repeated code
  let unusedVar = 42; // Unused variable
  let i;
  for (i = 0; i < 10; i++) {
    console.log(i);
    console.log(i); // Duplicated code
  }
  
  // Security hotspot
  let userInput = task;
  eval('console.log(' + userInput + ')');
  
  // Potential infinite loop
  while (true) {
    if (task.length > 0) break;
    console.log('Infinite loop risk');
  }
}

function deleteTodo(element) {
  // Bug: element not checked
  element.parentNode.remove();
}

function completeTodo(element) {
  // Repeated code
  let unusedVar2 = 'test'; // Unused variable
  element.style.textDecoration = 'line-through';
  element.style.textDecoration = 'line-through'; // Duplicated
}

// Duplicated function
function addTask() {
  addTodo(); // Same logic as addTodo
}