document.addEventListener('DOMContentLoaded', () => {
    const departamentoPSelect = document.getElementById('departamentoP');
    const municipioPSelect = document.getElementById('municipioP');

    async function loadCSV(file) {
        const response = await fetch(file);
        const data = await response.text();
        return data;
    }

    function parseCSV(data, isMunicipio = false) {
        const lines = data.trim().split('\n');
        const result = [];

        for (let i = 1; i < lines.length; i++) {
            const values = lines[i].split(',');
            if (isMunicipio) {
                const [idMunicipio, municipio, idDepartamento] = values;
                result.push({ idMunicipio, municipio: municipio.trim(), idDepartamento });
            } else {
                const [id, departamento] = values;
                result.push({ id, departamento: departamento.trim() });
            }
        }
        return result;
    }

    function populateDepartamentos(departamentos, selectElement) {
        selectElement.innerHTML = '<option value="">Selecciona un departamento</option>';
        departamentos.forEach(dep => {
            const option = document.createElement('option');
            option.value = dep.id;
            option.textContent = dep.departamento;
            selectElement.appendChild(option);
        });
    }

    function populateMunicipios(municipios, selectElement) {
        selectElement.innerHTML = '<option value="">Selecciona un municipio</option>';
        municipios.forEach(mun => {
            const option = document.createElement('option');
            option.value = mun.idMunicipio;
            option.textContent = mun.municipio;
            selectElement.appendChild(option);
        });
    }

    // Cargar y manejar los CSVs
    Promise.all([loadCSV('departamentos.csv'), loadCSV('municipios.csv')])
        .then(([departamentosCSV, municipiosCSV]) => {
            const departamentos = parseCSV(departamentosCSV);
            const municipios = parseCSV(municipiosCSV, true);

            // Poblar el selector de departamentos
            populateDepartamentos(departamentos, departamentoPSelect);

            // Evento para el selector de departamentoP
            departamentoPSelect.addEventListener('change', () => {
                const selectedDepartamentoP = departamentoPSelect.value;
                const filteredMunicipiosP = municipios.filter(m => m.idDepartamento === selectedDepartamentoP);
                populateMunicipios(filteredMunicipiosP, municipioPSelect);
            });
        })
        .catch(error => console.error('Error al cargar los archivos CSV:', error));
});
