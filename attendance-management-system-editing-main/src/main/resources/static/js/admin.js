const api = '/api';
const tbody = document.querySelector('#empTable tbody');

async function loadEmployees() {
  const res = await fetch(api + '/admin/employees');
  const list = await res.json();
  tbody.innerHTML = '';
  list.forEach(e => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${e.id}</td>
      <td>${e.name}</td>
      <td>${e.email}</td>
      <td>${e.role}</td>
      <td>${e.approved}</td>
      <td>
        <button onclick="approve(${e.id}, true)">Approve</button>
        <button class="secondary" onclick="approve(${e.id}, false)">Revoke</button>
        <button class="secondary" onclick="removeEmp(${e.id})">Delete</button>
      </td>`;
    tbody.appendChild(tr);
  });
}

async function approve(id, approved) {
  await fetch(api + `/admin/approve/${id}?approved=${approved}`, { method: 'POST' });
  loadEmployees();
}

async function removeEmp(id) {
  await fetch(api + `/admin/employees/${id}`, { method: 'DELETE' });
  loadEmployees();
}

document.getElementById('refresh')?.addEventListener('click', loadEmployees);
loadEmployees();
