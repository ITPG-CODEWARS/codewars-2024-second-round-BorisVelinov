document.getElementById('url-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const longUrl = document.getElementById('longUrl').value;
    const customAlias = document.getElementById('customAlias').value || null;
    const maxUses = document.getElementById('maxUses').value || null;
    const response = await fetch('/api/url/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ longUrl, customAlias, maxUses })
    });
    const result = await response.json();
    console.log(result);
});
