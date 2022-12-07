//package com.mjv.fontesdosgames.Service;
//
//import com.mjv.fontesdosgames.Mapper.EnderecoMapper;
//import com.mjv.fontesdosgames.Model.Endereco;
//import com.mjv.fontesdosgames.Recursos.EnderecoPostRequestBody;
//import com.mjv.fontesdosgames.Recursos.EnderecoPutRequestBody;
//import com.mjv.fontesdosgames.Repository.EnderecoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@Service
//public class EnderecoService {
//    @Autowired
//    private EnderecoRepository enderecoRepository;
//
//    public List<Endereco> listAll(){
//    return enderecoRepository.findAll();
//    }
//
//    public Endereco findByIdOrThrowBadRequestException (long id){
//        return enderecoRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel encontrar o endereço por id"));
//    }
//
//    public Endereco save(EnderecoPostRequestBody enderecoPostRequestBody){
//        return enderecoRepository.save(EnderecoMapper.INSTANCE.toEndereco(enderecoPostRequestBody));
//    }
//
//    public void delete(long id) {
//        enderecoRepository.delete(findByIdOrThrowBadRequestException(id));
//    }
//
//    public void replace(EnderecoPutRequestBody enderecoPutRequestBody) {
//        Endereco saveEndereco = findByIdOrThrowBadRequestException(enderecoPutRequestBody.getId());
//        Endereco endereco = EnderecoMapper.INSTANCE.toEndereco(enderecoPutRequestBody);
//
//        endereco.setId(saveEndereco.getId());
//
//        enderecoRepository.save(endereco);
//    }
//}
