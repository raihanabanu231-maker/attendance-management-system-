export function setSession(data) {
  localStorage.setItem('employeeId', data.employeeId);
  localStorage.setItem('role', data.role);
  localStorage.setItem('name', data.name || '');
  localStorage.setItem('department', data.department || '');
  localStorage.setItem('shift', data.shift || '');
}
export function getSession() {
  return {
    employeeId: Number(localStorage.getItem('employeeId') || 0),
    role: localStorage.getItem('role') || '',
    name: localStorage.getItem('name') || '',
    department: localStorage.getItem('department') || '',
    shift: localStorage.getItem('shift') || ''
  };
}
