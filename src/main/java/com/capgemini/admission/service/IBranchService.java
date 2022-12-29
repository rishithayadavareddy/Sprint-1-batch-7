package com.capgemini.admission.service;

import java.util.List;
import com.capgemini.admission.dto.BranchDTO;

public interface IBranchService {
	public BranchDTO addBranch(BranchDTO branchDTO);

	public BranchDTO updateBranch(BranchDTO branchDTO);

	public BranchDTO deleteBranch(BranchDTO branchDTO);

	public BranchDTO getByBranchId(int branchId);

	public List<BranchDTO> findAll();


}
