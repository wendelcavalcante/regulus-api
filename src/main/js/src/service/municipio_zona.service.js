import { regulus_api } from "../http-common";

export const MunicipioZonaDataService = {
  getAllMunicipios() {
    return regulus_api.get("/municipios");
  },
  getAllZonas() {
    console.log(window.location.hostname);
    return regulus_api.get("/zonas");
  },
  getAllMagistradosZona(sede) {
    return regulus_api.get(`/magistrados_zona?sede=${sede}`);
  },
  getMagistradoMatricula(sede) {
    return regulus_api.get(`/magistrado?sede=${sede}`);
  },
  getAllMagistrados(sede) {
    return regulus_api.get(`/magistrados`);
  }
};

/*class MunicipioDataService {
  getAll() {
    return http.get("/municipios");
  }

  get(id) {
    return http.get(`/municipios/${id}`);
  }

  findByTitle(nome) {
    return http.get(`/municipios?nome=${nome}`);
  }
}

export default new MunicipioDataService();*/