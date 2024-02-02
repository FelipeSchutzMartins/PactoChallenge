import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { inject } from '@angular/core';
import { StorageService } from '../_services/storage.service';

export const employerGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const router: Router = inject(Router);
  const protectedRoutes: string[] = ['/employerHome'];
  const storageService: StorageService = inject(StorageService);
  if (!storageService.getUser()) {
    return router.navigate(['/login'])
  }
  return protectedRoutes.includes(state.url) 
    && storageService.getUser().roles.includes('ROLE_EMPLOYER');
}

export const candidateGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const router: Router = inject(Router);
  const protectedRoutes: string[] = ['/candidateHome'];
  const storageService: StorageService = inject(StorageService);
  if (!storageService.getUser()) {
    return router.navigate(['/login'])
  }
  return protectedRoutes.includes(state.url) 
    && storageService.getUser().roles.includes('ROLE_CANDIDATE');
}

export const notLoggedGuard: CanActivateFn = (
  route: ActivatedRouteSnapshot,
  state: RouterStateSnapshot
) => {
  const router: Router = inject(Router);
  const protectedRoutes: string[] = ['/register', '/login'];
  const storageService: StorageService = inject(StorageService);

  if (storageService.getUser()) {
    if (storageService.getUser().roles.includes('ROLE_EMPLOYER')) {
      return router.navigate(['/employerHome'])
    }
    if (storageService.getUser().roles.includes('ROLE_CANDIDATE')) {
      return router.navigate(['/candidateHome'])
    }
  }

  return protectedRoutes.includes(state.url) 
    && storageService.getUser() == null;
}