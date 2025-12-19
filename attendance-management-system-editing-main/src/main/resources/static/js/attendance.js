const api = '/api';
const employeeIdInput = document.getElementById('employeeId');
const checkInBtn = document.getElementById('checkInBtn');
const checkOutBtn = document.getElementById('checkOutBtn');
const checkMsg = document.getElementById('checkMsg');
const recordsTable = document.querySelector('#recordsTable tbody');

const storedId = localStorage.getItem('employeeId');
if (storedId) employeeIdInput.value = storedId;

checkInBtn?.addEventListener('click', async () => {
  const body = {
    employeeId: Number(employeeIdInput.value),
    department: document.getElementById('department').value.trim(),
    shift: document.getElementById('shift').value
  };
  const res = await fetch(api + '/attendance/checkin', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(body)
  });
  const data = await res.json();
  checkMsg.textContent = data.success ? `Checked in at ${data.checkInTime}` : (data.message || 'Check-in failed');
  loadRecords();
});

checkOutBtn?.addEventListener('click', async () => {
  const id = Number(employeeIdInput.value);
  const res = await fetch(api + `/attendance/checkout/${id}`, { method: 'POST' });
  const data = await res.json();
  checkMsg.textContent = data.success ? `Checked out at ${data.checkOutTime}` : (data.message || 'Check-out failed');
  loadRecords();
});

async function loadRecords() {
  const id = Number(employeeIdInput.value);
  if (!id) return;
  const res = await fetch(api + `/attendance/employee/${id}`);
  const data = await res.json();
  recordsTable.innerHTML = '';
  data.forEach(a => {
    const badgeClass = a.status === 'CHECKED_IN' ? 'badge in' : 'badge out';
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${a.date}</td><td><span class="${badgeClass}">${a.status}</span></td><td>${a.checkInTime || '-'}</td><td>${a.checkOutTime || '-'}</td>`;
    recordsTable.appendChild(tr);
  });
}
loadRecords();
