function login(username, password) {
  // Security issue: Plain text password
  localStorage.setItem('password', password);
  
  // Unsafe function
  let result = eval('username + " logged in"');
  
  // Missing input validation
  if (username == password) {
    return true;
  }
  return false;
}

function logout() {
  // Bug: No actual logout logic
  console.log('Logged out');
}