const api = '/api';

function setSession(e) {
  localStorage.setItem('employeeId', e.employeeId);
  localStorage.setItem('role', e.role);
  localStorage.setItem('name', e.name || '');
}

document.getElementById('loginBtn')?.addEventListener('click', async () => {
  const email = document.getElementById('email').value.trim();
  const password = document.getElementById('password').value.trim();
  const res = await fetch(api + '/auth/login', {
    method: 'POST', headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ email, password })
  });
  const data = await res.json();
  const msg = document.getElementById('msg');
  if (data.success) {
    setSession(data);
    msg.textContent = `Welcome, ${data.name} (Role: ${data.role})`;
    window.location.href = data.role === 'ADMIN' ? 'admin.html' : 'employee-dashboard.html';
  } else {
    msg.textContent = data.message;
  }
});

document.getElementById('registerBtn')?.addEventListener('click', async () => {
  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('regEmail').value.trim();
  const password = document.getElementById('regPassword').value.trim();
  const res = await fetch(api + '/auth/register', {
    method: 'POST', headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ name, email, password })
  });
  const data = await res.json();
  alert(data.id ? `Registered. Await admin approval. Your ID=${data.id}` : 'Registration failed');
});
