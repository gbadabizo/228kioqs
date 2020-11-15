package com.all4tic.kioqs.service;

import java.util.List;

import com.all4tic.kioqs.models.Publicite;

public interface PubliciteService {
	Publicite addPublicite(Publicite pub);
	List<Publicite> listPublicite();
}
