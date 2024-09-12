document.addEventListener('DOMContentLoaded', () => {
    // Referencias a los elementos de los selects
    const departamentoSelect = document.getElementById('departamento');
    const municipioSelect = document.getElementById('municipio');

    // Función para leer el CSV
    async function loadCSV(file) {
        const response = await fetch(file);
        const data = await response.text();
        return data;
    }

    // Función para parsear el CSV (aplicable tanto para departamentos como municipios)
    function parseCSV(data, isMunicipio = false) {
        const lines = data.trim().split('\n');
        const result = [];

        for (let i = 1; i < lines.length; i++) {  // Saltar la primera línea (cabecera)
            const values = lines[i].split(',');
            if (isMunicipio) {
                // Para municipios, obtener idMunicipio, municipio y idDepartamento
                const [idMunicipio, municipio, idDepartamento] = values;
                result.push({ idMunicipio, municipio: municipio.replace(/\"/g, ''), idDepartamento });
            } else {
                // Para departamentos, obtener id y nombre
                const [id, departamento] = values;
                result.push({ id, departamento: departamento.replace(/\"/g, '') });
            }
        }

        return result;
    }

    // Función para poblar el select de departamentos
    function populateDepartamentos(departamentos) {
        departamentos.forEach(dep => {
            const option = document.createElement('option');
            option.value = dep.id;
            option.textContent = dep.departamento;
            departamentoSelect.appendChild(option);
        });
    }

    // Función para poblar el select de municipios
    function populateMunicipios(municipios) {
        municipioSelect.innerHTML = '';  // Limpiamos los municipios actuales
        municipios.forEach(mun => {
            const option = document.createElement('option');
            option.value = mun.idMunicipio;
            option.textContent = mun.municipio;
            municipioSelect.appendChild(option);
        });
    }

    // Cargar y manejar el archivo CSV de departamentos y municipios
    Promise.all([loadCSV('departamentos.csv'), loadCSV('municipios.csv')])
        .then(([departamentosCSV, municipiosCSV]) => {
            const departamentos = parseCSV(departamentosCSV);
            const municipios = parseCSV(municipiosCSV, true);

            // Poblar los departamentos en el select
            populateDepartamentos(departamentos);

            // Asignar evento para actualizar los municipios cuando se seleccione un departamento
            departamentoSelect.addEventListener('change', () => {
                const selectedDepartamento = departamentoSelect.value;
                
                // Filtrar los municipios que coinciden con el idDepartamento seleccionado
                const filteredMunicipios = municipios.filter(m => m.idDepartamento === selectedDepartamento);
                
                // Poblar el select de municipios con los municipios filtrados
                populateMunicipios(filteredMunicipios);
            });
        });
});
