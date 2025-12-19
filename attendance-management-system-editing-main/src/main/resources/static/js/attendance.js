const api = '/api';
const employeeIdInput = document.getElementById('employeeId');
const checkInBtn = document.getElementById('checkInBtn');
const checkOutBtn = document.getElementById('checkOutBtn');
const checkMsg = document.getElementById('checkMsg');
const recordsDiv = document.getElementById('records');

const storedId = localStorage.getItem('employeeId');
if (storedId) employeeIdInput.value = storedId;

checkInBtn?.addEventListener('click', async () => {
  const id = Number(employeeIdInput.value);
  if (!id) { checkMsg.textContent = 'Enter valid employee ID'; return; }
  const res = await fetch(api + `/attendance/checkin/${id}`, { method: 'POST' });
  const data = await res.json();
  checkMsg.textContent = data.success ? `Checked in at ${data.checkInTime}` : (data.message || 'Check-in failed');
  loadRecords();
});

checkOutBtn?.addEventListener('click', async () => {
  const id = Number(employeeIdInput.value);
  if (!id) { checkMsg.textContent = 'Enter valid employee ID'; return; }
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
  recordsDiv.innerHTML = '';
  const table = document.createElement('table');
  table.className = 'table';
  table.innerHTML = `<thead>
      <tr><th>Date</th><th>Status</th><th>Check-in</th><th>Check-out</th></tr>
    </thead><tbody></tbody>`;
  const tb = table.querySelector('tbody');
  data.forEach(a => {
    const tr = document.createElement('tr');
    const badgeClass = a.status === 'CHECKED_IN' ? 'badge in' : 'badge out';
    tr.innerHTML = `
      <td>${a.date}</td>
      <td><span class="${badgeClass}">${a.status}</span></td>
      <td>${a.checkInTime || '-'}</td>
      <td>${a.checkOutTime || '-'}</td>`;
    tb.appendChild(tr);
  });
  recordsDiv.appendChild(table);
}
loadRecords();
